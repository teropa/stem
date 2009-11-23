package org.eclipse.stem.ui.views.geographic.map;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import org.eclipse.stem.data.geography.Activator;

/**
 * Transform class to transform points from one coordinates space to another.
 * Offset and scale values are the values that will affect the transformation.
 * @author Yossi Mesika (IBM)
 */
public class StemPolygonTransform {
	
	private double offsetX = 0.0d;
	private double offsetY = 0.0d;
	private double scale = 1.0d;
	
	private Point2D getInversedPoint(Point toInverse) {
		AffineTransform transform = new AffineTransform();
		transform.setToTranslation(offsetX, offsetY);
		transform.scale(scale, scale);
		Point2D toReturn = new Point2D.Double(0, 0);
		try {
			toReturn = transform.inverseTransform(toInverse, toReturn);
		} catch (NoninvertibleTransformException e) {
			Activator.logError("Problem inverting point " + toInverse, e);
			return new Point();
		}
		return toReturn;
	}
	
	/**
	 * The method will return the inverted point of the specified coordinates.
	 * I.e. it will do reversed transformation.
	 * @param x X value of the point to be inverted
	 * @param y Y value of the point to be inverted
	 * @return the inverted point as an SWT {@link org.eclipse.swt.graphics.Point}
	 */
	public org.eclipse.swt.graphics.Point getInversedPoint(final int x, final int y) {
		Point2D transformed = getInversedPoint(new Point(x, y));
		return new org.eclipse.swt.graphics.Point((int)transformed.getX(), (int)transformed.getY());		
	}

	/**
	 * @return the offsetX
	 */
	public double getOffsetX() {
		return offsetX;
	}

	/**
	 * @param offsetX the offsetX to set
	 */
	public void setOffsetX(double offsetX) {
		this.offsetX = offsetX;
	}

	/**
	 * @return the offsetY
	 */
	public double getOffsetY() {
		return offsetY;
	}

	/**
	 * @param offsetY the offsetY to set
	 */
	public void setOffsetY(double offsetY) {
		this.offsetY = offsetY;
	}

	/**
	 * @return the scale
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(double scale) {
		this.scale = scale;
	}
	
}
