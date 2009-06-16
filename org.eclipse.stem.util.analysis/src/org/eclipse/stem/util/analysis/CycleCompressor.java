/**
 * 
 */
package org.eclipse.stem.util.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This class is designed to take a time series with multiple epidemic waves. It collapses the data into
 * a single "averaged" cycle aligning the peaks of each epidemic using a smoothing and peak finding algorithm
*/
public class CycleCompressor {
	
	org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl.ReferenceScenarioDataInstance data;
	
	/**
	 * this phase shift maximizes the correlation between the two vectors
	 */
	static final int WINDOW = 365;
	
	/**
	 * by default we will try to find max correlation for a shift of +/- 30 days
	 * if the vectors are shorter than this we reduce the window
	 */
	static final int INITIAL_PHASE_SHIFT = 30;
	
	/**
	 * the peak positions
	 */
	public static List<Integer> peakPositions = new ArrayList<Integer>();
	
	static List<Double> compressedCycles = new ArrayList<Double>();
	
	protected static final int[] DAY_OF_CHANNUKA = { 347, 702, 1086, 1430, 1794, 2179,
										   2533, 2916, 3271, 3625, 4008 };

	
	
	/**
	 * This class is designed to take a ReferenceScenarioDataInstance(s) and to reconstruct a single "averaged" or 
	 * typical epidemic wave from a time series containing many such waves.
	 * Note that the peak finder algorithm operates on smoothed data but once the peaks are located
	 * the integration and normalization is done with the raw data.
	 * @param dataInstance
	 * 
	 */
	public CycleCompressor(ReferenceScenarioDataInstance dataInstance) {
		data = dataInstance;
		String key = "Incidence"; // this only works for incidence data right now
		peakPositions = this.getDelayAfterChannuka(data, key );
		//peakPositions = this.getPeakPositions(data, key );
		
		
		for (int i = 0; i < peakPositions.size(); i ++) {
			int peak = peakPositions.get(i).intValue();
			System.out.print(""+peak+",");
		}
		System.out.println("-1");
		
		compressedCycles = this.compressData(data, peakPositions, key);
	}
	
	/**
	 * Finds index of peaks, returns as list
	 * @param instance
	 * @param key 
	 * @parameter key (must be I, E, or incidence - they have peaks)
	 * @return list of peak positions
	 */
	public List<Integer> getPeakPositions(ReferenceScenarioDataInstance instance, String key) {
		List<Integer> peaks = new ArrayList<Integer>();
		
		List<Double> vector = instance.getData().get(key);
		List<Double> smoothedOnce = smooth3(vector);
		List<Double> smoothed = smooth3(smoothedOnce);
		int istart = 0;
		int istop = INITIAL_PHASE_SHIFT;
		int peakPos = findPeak(smoothed,istart,istop);
		if(peakPos!=istart) peaks.add(new Integer(peakPos));
		int maxStartIndex = smoothed.size() - WINDOW/2;
		while(peakPos < maxStartIndex ) {
			istart = peakPos+(WINDOW/2);
			istop = istart + WINDOW;
			peakPos= findPeak(smoothed,istart,istop);
			peaks.add(new Integer(peakPos));
		}
		return peaks;
	}
	
	
	

	/**
	 * Finds index of peaks, returns as list
	 * @param instance
	 * @param key 
	 * @parameter key (must be I, E, or incidence - they have peaks)
	 * @return list of peak positions
	 */
	public List<Integer> getDelayAfterChannuka(ReferenceScenarioDataInstance instance, String key) {
		List<Integer> peaks = new ArrayList<Integer>();
		
		List<Double> vector = instance.getData().get(key);
		List<Double> smoothedOnce = smooth3(vector);
		List<Double> smoothed = smooth3(smoothedOnce);
		
		for (int i = 0; i < DAY_OF_CHANNUKA.length; i ++) {
			int istart = DAY_OF_CHANNUKA[i]-30;
			int istop = istart + 90;
			//int peakPos = findFirstPeak(smoothed,istart,istop);
			int peakPos = findPeak(smoothed,istart,istop);
			peaks.add(new Integer(peakPos));
		}
		
		return peaks;
	}
	
	
	/**
	 * Created and "averaged" cycle from several periods of data
	 * @param instance
	 * @param peaks
	 * @param key
	 * @return the compressed data
	 */
	public List<Double> compressData(ReferenceScenarioDataInstance instance, List<Integer> peaks, String key) {
		
		List<Double> data = instance.getData().get(key);
		double[] sum = new double[WINDOW];
		double[] denom = new double[WINDOW];
		//1.  init
		for(int i = 0; i < WINDOW; i ++) {
			sum[i] = 0.0;
			denom[i] = 0.0;
		}
	    //2.  integrate all cycles
		for (int iPeak = 0; iPeak < peaks.size(); iPeak ++) {
			int nextPeak = peaks.get(iPeak).intValue();
			int istart = nextPeak-WINDOW/2;
			
			int index = istart;	
			for(int i = 0; i < WINDOW; i ++) {
				if((index >=0)&&(index < data.size())) {
					double val = data.get(index).doubleValue();
					sum[i] += val;
					denom[i] += 1.0;
				}// if in bounds
				index ++;
			}// all data in window
			
		}// all peaks
		//3.  normalize the result 
		List<Double> compressed = new ArrayList<Double>();
		for(int i = 0; i < WINDOW; i ++) {
				if(denom[i] <= 0.0) denom[i] = 1.0; // always
				double val = sum[i] / denom[i];
				compressed.add(i,new Double(val));
		}// all data in window
		
		return compressed;
	}
	

	/**
	 * @param dataList
	 * @param istart
	 * @param istop
	 * @return index of peak position within window
	 */
	public static int findPeak(List<Double> dataList, int istart, int istop) {
		int peakIndex = istart;
		double peakVal = 0.0;
		for (int i = istart; i < istop; i ++) {
			if(i < dataList.size() ) {
				double val = dataList.get(i).doubleValue();
				if(val>peakVal) {
					peakVal = val;
					peakIndex = i;
				}// if peak
			}// if not end of data
		}// for all data
		//System.out.println("found peak at "+peakIndex+" val="+peakVal);
		return peakIndex;
	}// findPeak


	/**
	 * @param dataList
	 * @param istart
	 * @param istop
	 * @return index of peak position within window
	 */
	public static int findFirstPeak(List<Double> dataList, int istart, int istop) {
		int peakIndex = istart;
		double peakVal = 0.0;
		for (int i = istart; i < istop; i ++) {
			if(i < dataList.size() ) {
				double val = dataList.get(i).doubleValue();
				if(val>=peakVal) {
					peakVal = val;
					peakIndex = i;
				}// if peak
				else {
					return peakIndex;
				}
			}// if not end of data
		}// for all data
		//System.out.println("found peak at "+peakIndex+" val="+peakVal);
		return peakIndex;
	}// findPeak
	
	
	
	/** 
	 * do a three point smooth
	 * @param dataList
	 * @return the smoothed data
	 */
	public static List<Double> smooth3(List<Double> dataList) {
		List<Double> smooth = new ArrayList<Double>();
		double v0 = dataList.get(0).doubleValue();
		double v1 = dataList.get(1).doubleValue();
		// add the first endpoint
		smooth.add( new Double( (v0+v1)/2.0) );
		
		// add the others
		for (int i = 1; i < dataList.size()-1; i ++) {
			double d1 = dataList.get(i-1).doubleValue();
			double d2 = dataList.get(i).doubleValue();
			double d3 = dataList.get(i+1).doubleValue();
			smooth.add(i, new Double( (d1+d2+d3)/3.0) );
		}
		int iLast = dataList.size() -1;
		// add the last end point
		v0 = dataList.get(iLast).doubleValue();
		v1 = dataList.get(iLast-1).doubleValue();
		smooth.add( new Double( (v0+v1)/2.0) );
		
		return smooth;
	}// smooth
	


	/**
	 * get the result
	 * @return cycle compressed data
	 */
	public double[] getCompressedData() {
		double[] values = new double[compressedCycles.size()];
		for (int i = 0; i < compressedCycles.size(); i ++) {
			values[i] = compressedCycles.get(i).doubleValue();
		}
		return values;
	}
 
}
