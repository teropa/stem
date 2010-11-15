// LatLong.java
package org.eclipse.stem.definitions.adapters.spatial.geo;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.stem.definitions.Activator;

/**
 * This class is a collection of latitude/longitude data pairs partitioned into
 * one or more "segments". Each segment is a sequence of latitude/longitude data
 * pairs. A segment could form a closed polygon or it could be a path. A
 * {@link SegmentBuilder} can be used to construct a {@link Segment}.
 */
public class LatLong {

	private static final int NUMBER_OF_FACTIONAL_DIGITS = 2;

	//static NumberFormat formatter = null;

	private final List<Segment> segments = new ArrayList<Segment>();

	/**
	 * Add a segment to a collection
	 * 
	 * @param segment
	 *            the segment to add to the collection
	 */
	public void add(final Segment segment) {
		segments.add(segment);
	}

	/**
	 * @param segments
	 *            add the list of segments to the collection maintained by
	 *            LatLong
	 */
	public void add(final List<Segment> segments) {
		this.segments.addAll(segments);
	} // add

	/**
	 * Add the segments from one <code>LatLong</code> to this one.
	 * 
	 * @param latLong
	 *            the <code>LatLong</code> instance that contains the segments
	 *            to add.
	 */
	public void add(final LatLong latLong) {
		segments.addAll(latLong.getSegments());
	} // add

	/**
	 * @return the list of segments
	 */
	public final List<Segment> getSegments() {
		return segments;
	} // getSegments

	/**
	 * @return the number of segments
	 */
	public final int size() {
		return segments.size();
	} // size

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Integer.toString(size());
	} // toString

	/**
	 * @return a number formatter
	 */
//	static NumberFormat getFormatter() {
//		// Is there already a formatter?
//		if (formatter == null) {
//			// No
//			formatter = NumberFormat.getNumberInstance();
//			formatter.setMaximumFractionDigits(NUMBER_OF_FACTIONAL_DIGITS);
//			formatter.setMinimumFractionDigits(NUMBER_OF_FACTIONAL_DIGITS);
//		}
//		return formatter;
//	} // getFormatter
	
	/**
	 * Converts double value into a fractional string with fracDigits 
	 * number of decimal places.  Should be locale agnostic.
	 * @param value value to convert
	 * @param fracDigits number of digits after decimal point to hold
	 * @return String containing new value
	 */
	static String formatLatLngValue(double value, double fracDigits) {
		
		double power = Math.pow(10, fracDigits);
		return String.valueOf(((long)(value*power))/power);
	}
	
	/**
	 * Converts double value into a fractional string with default 
	 * number of decimal places.  Should be locale agnostic.
	 * @param value value to convert
	 * @return String containing new value
	 */
	static String formatLatLngValue(double value) {
		return formatLatLngValue(value, NUMBER_OF_FACTIONAL_DIGITS);
	}

	/**
	 * This class creates {@link Segment}'s
	 */
	public static class SegmentBuilder {

		private final List<LatLongPair> collectedPairs = new ArrayList<LatLongPair>();

		/**
		 * @param latitudeString
		 *            a double latitude value represented as a
		 *            <code>String</code>
		 * @param longitudeString
		 *            a double longitude value represented as a
		 *            <code>String</code>
		 * @throws NumberFormatException
		 */
		public void add(final String latitudeString,final String longitudeString) throws NumberFormatException {
			double dLat = Double.parseDouble(latitudeString);
			double dLng = Double.parseDouble(longitudeString);
			add(dLat,dLng);
		} // add


		/**
		 * @param latitude
		 * @param longitude
		 */
		public void add(final double latitude, final double longitude) {
			collectedPairs.add(new LatLongPair(latitude, longitude));
		} // add

		/**
		 * @return the number of latitude/longitude data pairs in the segment
		 *         being built.
		 */
		public int size() {
			return collectedPairs.size();
		} // size

		/**
		 * Remove all of the collected latitude/longitude pairs collected so far
		 */
		public void clear() {
			collectedPairs.clear();
		} // clear

		/**
		 * @return the collected latitude/longitude data pairs as a segment.
		 */
		public Segment toSegment() {
			return toSegment(collectedPairs);
		} // toSegment

		/**
		 * Create a {@link Segment}, but reduce the number of data points it
		 * contains by the sample frequency. A value of "1" means all points are
		 * included, a value of "2" means that every 2nd point is included. The
		 * first and last points are always included.
		 * 
		 * @param sampleFrequency
		 *            the frequency in data points at which the pairs are
		 *            sampled.
		 * @return a subset of the collected latitude/longitude data pairs as a
		 *         segment.
		 * @throws IllegalArgumentException if sampleFrequency is < 1
		 */
		public Segment toSegment(final int sampleFrequency) {
			return toSegment(createDownSampledPairs(sampleFrequency,
					collectedPairs));
		} // toSegment

		/**
		 * @param sampleFrequency  the frequency in data points at which the pairs are
		 *            sampled.
		 * @param pairs
		 * @throws IllegalArgumentException if sampleFrequency is < 1
		 */
		private final List<LatLongPair> createDownSampledPairs(
				final int sampleFrequency, final List<LatLongPair> pairs) {
			final List<LatLongPair> downSampledPairs = new ArrayList<LatLongPair>();

			// Is the sample frequency too small?
			if (sampleFrequency >= 1) {
				// No
				final int lastPoint = collectedPairs.size() - 1;

				// Is it greater than or equal to the number of pairs?
				if (sampleFrequency < lastPoint) {
					// No
					int dataPointCounter = 0;
					for (final LatLongPair pair : pairs) {
						// Include this point?
						if (dataPointCounter % sampleFrequency == 0
								|| dataPointCounter == lastPoint) {
							// Yes
							downSampledPairs.add(pair);
						} // if include this point
						dataPointCounter++;
					} // for each lat/long point
				} // if sample frequency not greater than number of pairs
				else {
					// Yes
					// Pick the first point, the middle point and the last point
					downSampledPairs.add(pairs.get(0));
					downSampledPairs.add(pairs.get(pairs.size() / 2));
					downSampledPairs.add(pairs.get(lastPoint));
				} // else

			} // if sample frequency not too small
			else {
				// Yes
				// Bad sample frequency
				throw new IllegalArgumentException("Sample frequency \""
						+ sampleFrequency + "\" must be 1 or greater");
			}

			return downSampledPairs;
		} // createDownSampledPairs

		/**
		 * @param pairs
		 *            a list of lat/long data pairs
		 * @return the latitude/longitude data pairs as a segment.
		 */
		private Segment toSegment(final List<LatLongPair> pairs) {
			final double[][] data = new double[pairs.size()][2];

			int i = 0;
			for (final LatLongPair latLongPair : pairs) {
				data[i][Segment.LATITUDE_INDEX] = latLongPair.latitude;
				data[i][Segment.LONGITUDE_INDEX] = latLongPair.longitude;
				i++;
			}
			return new Segment(data);
		} // toSegment

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			// Any latitude/longitude pairs?
			if (size() > 0) {
				sb.append(collectedPairs.get(0).toString());
				// More than 2?
				if (size() > 2) {
					// Yes
					sb.append("...<" + (size() - 2) + ">...");
				}
				// Were there at least two?
				if (size() > 1) {
					// Yes
					sb.append(collectedPairs.get(size() - 1).toString());
				}
			} // if any pairs

			return sb.toString();
		} // toString

		/**
		 * This class represents a latitude/longitude data pair.
		 */
		private static class LatLongPair {
			double latitude = 0.0;

			double longitude = 0.0;

			/**
			 * @param lat
			 * @param lng
			 */
			protected LatLongPair(final double latitude, final double longitude) {
				super();
				assert longitude >= -180.0 && longitude <= 180.0;
				assert latitude >= -90.0 && latitude <= 90.0;
				this.latitude = latitude;
				this.longitude = longitude;
			} // LatLongPair

			/**
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				final StringBuffer sb = new StringBuffer();
				sb.append(formatLatLngValue(latitude));
				sb.append(", ");
				sb.append(formatLatLngValue(longitude));
				return sb.toString();
			}

		} // LatLongPair
	} // SegmentBuilder

	/**
	 * This class represents a sequence of latitude/longitude data pairs. A
	 * segment could form a closed polygon or it could be a path.
	 */
	public static class Segment {

		// In a two element array this is the index of the latitude value
		static final int LATITUDE_INDEX = 0;

		// In a two element array this is the index of the longitude value
		static final int LONGITUDE_INDEX = 1;

		/**
		 * The latitude/longitude data pairs.
		 */
		private double[][] data = null;

		/**
		 * @param data
		 *            an array of latitude/longitude pairs
		 */
		public Segment(final double[][] data) {
			this.data = data;
		} // Segment

		/**
		 * @param i
		 *            the index of the data pair
		 * @return the latitude value of the i'th latitude/longitude data pair
		 */
		public double latitude(final int i) {
			return data[i][LATITUDE_INDEX];
		} // latitude

		/**
		 * @param i
		 *            the index of the latitude/longitude data pair
		 * @return the longitude value of the i'th latitude/longitude data pair
		 */
		public double longitude(final int i) {
			return data[i][LONGITUDE_INDEX];
		} // longitude

		/**
		 * @return the number of latitude/longitude data pairs
		 */
		public int size() {
			return data.length;
		} // size

		/**
		 * @return <code>true</code> if the sequence of lat/long pairs form a
		 *         closed polygon, <code>false</code>, otherwise.
		 */
		public boolean isPolygon() {
			final int size = data.length;
			return size > 2 && data[0][0] == data[size - 1][0]
					&& data[0][1] == data[size - 1][1];
		} // isPolygon

		/**
		 * @return create a URI string the encodes the latitude/longitude values
		 */
		public String toInlineURIString() {
			final StringBuilder sb = new StringBuilder();

			for (int i = 0; i < data.length; i++) {
				sb.append(formatLatLngValue(data[i][LATITUDE_INDEX]));
				sb.append(",");
				sb.append(formatLatLngValue(data[i][LONGITUDE_INDEX]));
				// Any more values?
				if (i < data.length - 1) {
					// Yes
					sb.append(",");
				}
			}
			return sb.toString();
		} // toInlineURIString

		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {

			final StringBuilder sb = new StringBuilder();
			// Any latitude/longitude pairs?
			if (data.length > 0) {
				// Yes
				sb.append(formatLatLngValue(data[0][LATITUDE_INDEX]));
				sb.append(",");
				sb.append(formatLatLngValue(data[0][LONGITUDE_INDEX]));

				// More than 2?
				if (data.length > 2) {
					// Yes
					sb.append("...<" + (data.length - 2) + ">...");
				}
				// Were there at least two?
				if (data.length > 1) {
					// Yes
					sb.append(formatLatLngValue(
							data[data.length - 1][LATITUDE_INDEX]));
					sb.append(",");
					sb.append(formatLatLngValue(
							data[data.length - 1][LONGITUDE_INDEX]));
				}

			} // if any pairs

			return sb.toString();
		} // toString

		/**
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {

			double sum = 1.0;
			for (final double[] element : data) {
				sum += Math.abs(element[0] + element[1]);
			}

			//$ANALYSIS-IGNORE
			final int temp = ((int) sum) * 31;

			return temp + data.length;
			// final int PRIME = 31;
			// int result = 1;
			// result = PRIME * result + Arrays.hashCode(data);
			// return result;
		}

		/**
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Segment other = (Segment) obj;

			if (data.length != other.data.length) {
				return false;
			}

			for (final double[] element : data) {
				if (element[LATITUDE_INDEX] != element[LATITUDE_INDEX]) {
					return false;
				}
				if (element[LONGITUDE_INDEX] != element[LONGITUDE_INDEX]) {
					return false;
				}
			}

			// if (!Arrays.equals(data, other.data))
			// return false;
			return true;
		}

	} // Segment

} // LatLong
