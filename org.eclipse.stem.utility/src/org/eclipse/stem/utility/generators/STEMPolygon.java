package org.eclipse.stem.utility.generators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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

/**
 * STEM II Data Migration/Generation Utilities : Instances of this utility class
 * are a a holder for polygon data. It is used in checkings for duplicate or
 * non-polygon data
 * 
 */

public class STEMPolygon {

	private List<PointData> list = new ArrayList<PointData>();

	private String _data = null;

	private int _level = -1;

	private PointData init = null;

	private PointData last = null;

	private Double ltPoints[] = null;

	private Double lgPoints[] = null;

	/**
	 * Constructor
	 * 
	 * @param data
	 *            raw polygon data (lt, lg) values
	 * @param level
	 *            the admin level for this data
	 */
	public STEMPolygon(String data, int level) {
		_data = data;
		_level = level;
		extractLtLgData();
		ltPoints = new Double[list.size()];
		lgPoints = new Double[list.size()];
		// Clear the data buffer to be more memory-efficient
		_data = null;
	}

	/**
	 * Get the number of points in a polygon.
	 * 
	 * @return the number of points in a given polygon.
	 */
	public int points() {
		return list.size();
	}

	/**
	 * Clear this polygon
	 */
	void clear() {
		list.clear();
		lgPoints = null;
		ltPoints = null;
		init = null;
		last = null;
	}

	/**
	 * Convert the value of string to a double
	 * 
	 * @param str
	 *            the string representation of a double.
	 * 
	 * @return double value extracted from numeric string
	 */
	protected double getDouble(String str) {
		Double holder = new Double(str);
		return holder.doubleValue();
	}

	/**
	 * Test if the string contains a number
	 * 
	 * @param str
	 *            the value we want to test
	 * 
	 * @return true if this value is numeric
	 */
	protected boolean isNumeric(String str) {

		try {
			Double.valueOf(str);
		} catch (NumberFormatException e) { // If an exception is thrown, then
			// it is not a number. Otherwise it
			// is.
			return false;
		}
		return true;
	}

	/**
	 * Tests whether another polygon and THIS polygon are the same
	 * 
	 * @param polygon
	 *            the other polygon we want to compare agains THIS one
	 * 
	 * @return true if these two polygons are the same
	 */
	public boolean same(STEMPolygon polygon) {

		// If they dont have the same number of points they cant be the same
		// polygon.
		if (list.size() != polygon.points()) {
			return false;
		}

		// Otherwise, compare if they have the same starting and ending points.
		// If they dont, then they cant be the same point.

		if (init != polygon.getInit()) {
			return false;
		} else if (last != polygon.getLast()) {
			return false;
		}

		// Finally, since they have the same number of points, the same starting
		// and ending points, check the
		// intermediate points to see if they are really the same.

		// advance the first token which we know already to be the same
		Iterator it1 = list.iterator();
		Iterator it2 = list.iterator();

		PointData d1 = null;
		PointData d2 = null;

		while (it1.hasNext()) {

			d1 = (PointData) it1.next();
			d2 = (PointData) it2.next();

			if (d1.same(d2) != true) {
				return false;
			}

		}

		// Yes, both polygons are the same.
		return true;
	}

	/**
	 * convert to degrees and change format of data to STEM convention -- eight
	 * digits, no decimal point
	 * 
	 * @param value
	 *            in radians
	 * 
	 * @return the angle value in degrees
	 */
	protected double toDegrees(double value) {
		double dValue = value;
		dValue *= 180.0;
		dValue /= java.lang.Math.PI;
		// return (int) (1000000.0 * value);
		return dValue;
	} // toDegrees

	/**
	 * Get all the lt points in this polygon
	 * 
	 * @return the lt points
	 */
	public Double[] getLtPoints() {

		int index = 0;
		Iterator it = list.iterator();

		while (it.hasNext()) {
			PointData pData = (PointData) it.next();
			ltPoints[index++] = new Double(toDegrees(pData.getLt()));
		}

		return ltPoints;
	}

	/**
	 * Get all the lg points in this polygon
	 * 
	 * @return the lg points
	 */
	public Double[] getLgPoints() {

		int index = 0;
		Iterator it = list.iterator();

		while (it.hasNext()) {
			PointData pData = (PointData) it.next();
			lgPoints[index++] = new Double(toDegrees(pData.getLg()));
		}

		return lgPoints;
	}

	/**
	 * Extract the lat, long data from the data buffer
	 * 
	 */
	protected void extractLtLgData() {

		/**
		 * This method creates the XML tags that deal with polygon data and
		 * includes the polygon data in it.
		 * 
		 * @param id
		 * @param data
		 * @return
		 */

		int offset = 0;
		final int INVALID = -10000000;
		double lt = INVALID;
		double lg = INVALID;

		switch (_level) {

		case DataTypes.LEVEL_0:
			offset = 2;
			break;

		case DataTypes.LEVEL_1:
			offset = 3;
			break;

		case DataTypes.LEVEL_2:
			offset = 4;
			break;
		}

		// Tokenize
		StringTokenizer tokens = new StringTokenizer(_data, ","); //$NON-NLS-1$

		// Advance the first K-tokens.
		for (int i = 0; i < offset; i++) {
			if (tokens.hasMoreTokens()) {
				tokens.nextToken();
			}
		}

		// We are now located at the beginning of the polygon data.
		while (tokens.hasMoreTokens()) {

			String token = tokens.nextToken();

			if (isNumeric(token) == false) {
				continue; // Ignore, this is not a valid coordinate.
			}

			if (lt == INVALID) {
				lt = getDouble(token);
			} else if (lg == INVALID) {
				lg = getDouble(token);
			}

			if (lt != INVALID && lg != INVALID) {
				// PointData point = new PointData(toDegrees(lt),
				// toDegrees(lg));
				PointData point = new PointData(lt, lg);
				if (init == null) {
					init = point;
				}
				last = point;
				// Eliminate repeated points : for every new point, add to list
				// only if it is not duplicated
				// if (checkDuplicatedPoints(point) == false) {
				list.add(point);
				// }
				lt = INVALID;
				lg = INVALID;
			}
		}

	} // extractLtLgData

	/**
	 * Check for duplicated points in the polygon
	 */
	// private boolean checkDuplicatedPoints(PointData point) {
	//
	// Iterator it = this.list.iterator();
	//
	// // Iterate through all the points in the polygon, avoid duplicates.
	// while (it.hasNext()) {
	//
	// PointData current = (PointData) it.next();
	// // Check to see if these two polygons are the same
	// // NOTE: the exception if the initial polygon
	// if (point.same(current)) {
	// return true;
	// }
	// }
	// // Not duplicated
	// return false;
	// }
	/**
	 * Get the starting point of a polygon
	 * 
	 * @return the first point of a polygon
	 */
	public PointData getInit() {
		return init;
	}

	/**
	 * Get the last point of a polygon
	 * 
	 * @return the last point of a polygon
	 */
	public PointData getLast() {
		return last;
	}

	/**
	 * Get iterator to list of polygon data objects.
	 * 
	 * @return an iterator through our list of polygons
	 */
	public Iterator getIterator() {
		return list.listIterator();
	}

}

/**
 * A utility class used to hold polygon data. An instance of this class
 * represents a single point.
 * 
 */
class PointData {

	private double _lt = -1;

	private double _lg = -1;

	/**
	 * Constructor
	 * 
	 * @param lt
	 *            the latitude in degrees
	 * @param lg
	 *            the longitude in degress
	 */
	public PointData(double lt, double lg) {
		// _lt = GenUtils.toDegrees(lt);
		// _lg = GenUtils.toDegrees(lg);
		_lt = lt;
		_lg = lg;
	}

	/**
	 * Get the latitude value
	 * 
	 * @return the latitude in degress
	 * 
	 */
	public double getLt() {
		return _lt;
	}

	/**
	 * Get the longitude value
	 * 
	 * @return the longitude in degress
	 */
	public double getLg() {
		return _lg;
	}

	/**
	 * Set the latitude
	 * 
	 * @param lt
	 *            the latitude
	 */
	public void setLt(double lt) {
		_lt = lt;
	}

	/**
	 * Set the longitude
	 * 
	 * @param lg
	 *            the longitude
	 */
	public void setLg(double lg) {
		_lg = lg;
	}

	/**
	 * Check to see if two point objects are the same.
	 * 
	 * @param point
	 *            the point data holder
	 * 
	 * @return true if two points are the same
	 */
	public boolean same(PointData point) {

		if (this._lt != point._lt) {
			return false;
		} else if (this._lg != point._lg) {
			return false;
		}

		// Yes, it is the same data.
		return true;
	}
}
