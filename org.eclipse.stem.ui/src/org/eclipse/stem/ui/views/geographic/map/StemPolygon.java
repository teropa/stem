package org.eclipse.stem.ui.views.geographic.map;

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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * A sub-class of java.awt.Polygon that has an extra field saving the relative
 * value of the polygon. The relative values could be used for intensity values
 * of the labels.
 */
public class StemPolygon {

	private static final int LATITUDE_DIRECTION = -1;

	private static final long serialVersionUID = 1L;
	
	/**
	 * This value is selected to convert lat/long values to integers with six
	 * digits of precision extracted from the original double values.
	 */
	private final static int scalingFactorForData = 1000000;

	/**
	 * This is the {@link Identifiable} instance associated with the polygon.
	 */
	private transient Identifiable identifiable;
	
	/**
	 * An array of all points (better used by SWT drawing)
	 */
	public int[] points = null;
	/**
	 * An array of all points, transformed to scale and offsets
	 */
	public int[] transformedPoints = null;
	private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

	/**
	 * Empty constructor.
	 * 
	 */
	public StemPolygon() {
		super();
	}

	/**
	 * Gets a list of a latLongData arrays, and transforms it into a Polygon.
	 * 
	 * @param latLongSegment
	 * @param identifiable
	 *            the {@link Identifiable} associated with the polygon.
	 */
	public StemPolygon(final Segment latLongSegment, final Identifiable identifiable) {
		super();
		this.identifiable = identifiable;

		final int size = latLongSegment.size();
		points = new int[2*size];

		for (int i = 0, pointsIndex = 0; i < size; i++, pointsIndex+=2) {
			addPoint(latLongSegment.longitude(i), latLongSegment.latitude(i), pointsIndex);
		}
		// }
	} // StemPolygon

//	/**
//	 * Add latLong coordinates to a polygon.
//	 * 
//	 * @param latLongData
//	 */
//	public void addLatLongData(final LatLong latLongData) {
//		final List<Segment> latLongSegmentsList = latLongData.getSegments();
//
//		for (final Segment latLongSegment : latLongSegmentsList) {
//			if (latLongSegment.isPolygon()) {
//				final int size = latLongSegment.size();
//				for (int i = 0, pointsIndex = 0; i < size; i++, pointsIndex+=2) {
//					addPoint(latLongSegment.longitude(i), latLongSegment
//							.latitude(i), pointsIndex);
//				}
//			}
//		} // for
//	} // addLatLongData

	/**
	 * 
	 * @param longitude
	 *            longitude value
	 * @param latitude
	 *            latitude value
	 * @param pointsIndex 
	 */
	private void addPoint(final double longitude, final double latitude, final int pointsIndex) {
		int x = (int)(longitude * scalingFactorForData);
		int y = (int)(latitude * scalingFactorForData * LATITUDE_DIRECTION);
		points[pointsIndex] = x;
		points[pointsIndex+1] = y;
		
		maxX = Math.max(x, maxX);
		maxY = Math.max(y, maxY);
		minX = Math.min(x, minX);
		minY = Math.min(y, minY); 
	} // addPoint
	
	/**
	 * @param pointsTransformer the pointsTransformer to set
	 */
	public void setPointsTransformer(StemPolygonTransform pointsTransformer) {
		transformedPoints = new int[getNumberOfPoints()*2];		
		for (int i=0; i<getNumberOfPoints(); i++) {
			int xBefore = points[2*i];
			int yBefore = points[2*i+1];
			int xAfter = (int) ((xBefore * pointsTransformer.getScale()) + pointsTransformer.getOffsetX());
			int yAfter = (int)((yBefore * pointsTransformer.getScale()) + pointsTransformer.getOffsetY());
			transformedPoints[2*i] = xAfter;
			transformedPoints[2*i+1] = yAfter;
		}
	}

	/**
	 * method to unscale the value that had been scaled by the above addPoint
	 * method.
	 * 
	 * @param longitude
	 * @return unscaled value
	 */
	public double unScaleLongitude(final double longitude) {
		return longitude / scalingFactorForData;
	}

	/**
	 * method to unscale the value that had been scaled by the above addPoint
	 * method.
	 * 
	 * @param latitude
	 * @return unscaled value
	 */
	public double unScaleLatitude(final double latitude) {
		return latitude / scalingFactorForData * LATITUDE_DIRECTION;
	}

	/**
	 * Returns the title of the polygon.
	 * 
	 * @return String
	 */
	public String getTitle() {
		return identifiable.getDublinCore().getTitle();
	} // getTitle

	/**
	 * @return the <code>Identifiable</code>
	 */
	public final Identifiable getIdentifiable() {
		return identifiable;
	}

	/**
	 * @param identifiable
	 *            the <code>Identifiable</code> to set
	 */
	public final void setIdentifiable(final Identifiable identifiable) {
		this.identifiable = identifiable;
	}
	
	/**
	 * The method returns the smallest {@link Rectangle} that bounds of the polygon.
	 * @return {@link Rectangle} of the bounds of the polygon
	 */
	public Rectangle getBounds() {
		if (minX == Integer.MAX_VALUE && maxY == Integer.MIN_VALUE) {
			return null;
		}
		Rectangle bounds = new Rectangle(minX, minY, (maxX - minX), (maxY - minY));
		return bounds;
	}
	
	/**
	 * Returns whether the point (x,y) is contained inside this polygon. 
	 * @param point the X and Y coordinates
	 * @return whether the point (x,y) is contained in this polygon
	 */
	public boolean containsPoint(Point point) {
		return containsPoint(point.x, point.y);
	}
	
	/**
	 * Returns whether the point (x,y) is contained inside this polygon. 
	 * @param x The X value of the point
	 * @param y The Y value of the point
	 * @return whether the point (x,y) is contained in this polygon
	 */
	public boolean containsPoint(int x, int y) {
		int i, j;
		boolean isInside = false;
		int numOfPoints = points.length / 2;
        
		for (i = 0, j = (numOfPoints-1)*2; i < points.length-1; ) {
			if ((((points[i+1]<=y) && (y<points[j+1])) ||
				((points[j+1]<=y) && (y<points[i+1]))) &&
				(x < (points[j] -  points[i]) * (y - points[i+1]) / (points[j+1] - points[i+1]) + points[i])) {
				isInside = !isInside;
			}
			j = i;
			i += 2;			
		}
		return isInside;
	}

	/**
	 * Returns the number of lat/long points that this polygon has
	 * @return the number of lat/long points
	 */
	public int getNumberOfPoints() {
		if (points == null)
			return 0;
		return points.length / 2;
	}

	/**
	 * Returns the non-scaled value of the latitude of the specific point
	 * @param i Point index
	 * @return the non-scaled value of the latitude of the specific point
	 */
	public double getNonScaledLatitude(final int i) {
		return (double)points[2*i+1] / (double)scalingFactorForData;
	}

	/**
	 * Returns the non-scaled value of the longitude of the specific point
	 * @param i Point index
	 * @return the non-scaled value of the longitude of the specific point
	 */
	public double getNonScaledLongitude(final int i) {
		return (double)points[2*i] / scalingFactorForData * LATITUDE_DIRECTION;
	}
	
	/**
	 * Returns the unscaled value of the provided latitude
	 * @param latValue the scaled latitude value
	 * @return the unscaled value of the provided latitude
	 */
	public static double getUnscaledLatitude(final int latValue) {
		return (double)latValue / (double)scalingFactorForData;
	}
	
	/**
	 * Returns the unscaled value of the provided longitude
	 * @param longValue the scaled latitude value
	 * @return the unscaled value of the provided longitude
	 */
	public static double getUnscaledLongitude(final int longValue) {
		return (double)longValue / scalingFactorForData * LATITUDE_DIRECTION;
	}

} // StemPolygon
