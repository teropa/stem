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

import java.util.LinkedList;

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Edge;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.stem.definitions.nodes.Region;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * A class that extends the LinkedList<stemPolygon> class. It has some fields
 * that help in managing the polygons list of a map, such as the offset needed
 * to be made in order to centralize the map, the optimum values of the map
 * coordinates, etc.
 * 
 */
public class StemPolygonsList extends LinkedList<StemPolygon> {

	private static final long serialVersionUID = 1L;

	private transient Rectangle bounds = null;

	/**
	 * Empty Constructor
	 * 
	 */
	public StemPolygonsList() {
		super();
	}

	/**
	 * Constructor which gets a LatLong object and constructs a list of polygons
	 * 
	 * @param latLongData
	 * @param identifiable
	 *            the <code>Identifiable</code> that is associated with the
	 *            polygon data.
	 */
	public StemPolygonsList(final LatLong latLongData,
			final Identifiable identifiable) {
		super();
		for (final Segment latLongSegment : latLongData.getSegments()) {
			add(new StemPolygon(latLongSegment, identifiable));
		}
	} // StemPolygonsList

	/**
	 * Compare the boundaries of a polygon to those of the list and update if
	 * necessary.
	 * 
	 * @param polygon
	 *            the polygon to use to update the minimum/maximum values
	 */
	private void updateBounds(final StemPolygon polygon) {
		//Only update the bounds for polygon of nodes
		if (polygon.getIdentifiable() instanceof Edge)
			return;
		// Bounds yet?
		if (bounds != null) {
			// Yes			
			bounds = bounds.union(polygon.getBounds());
		} // if
		else { 
			bounds = polygon.getBounds();
		}
	} // updateBounds

	/**
	 * @return the bounding box that contains all of the polygons in the list.
	 */
	public final Rectangle getBounds() {
		for (StemPolygon polygon : this) {
			updateBounds(polygon);
		}
		return bounds;
	} // getBounds

	/**
	 * @param latLongPosition
	 *            the position contained by a polygon (or not)
	 * @return the polygon that contains the point, or <code>null</code> if
	 *         the point lies outside of a polygon.
	 */
	public StemPolygon getContainingRegionPolygon(final Point latLongPosition) {
		StemPolygon retValue = null;
		for (final StemPolygon polygon : this) {
			// Does the polygon contain the point?
			if (polygon.containsPoint(latLongPosition)) {
				// Yes
				//Is this polygon a region?
				if (polygon.getIdentifiable() instanceof Region) {
					//Yes
					retValue = polygon;
					break;
				}
			} // if
		} // for each StemPolygon
		return retValue;
	} // getContainingPolygon
} // StemPolygonsList
