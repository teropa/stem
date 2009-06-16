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

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

/**
 * Helper class allowing the use of Java 2D on SWT or Draw2D graphical context.
 * See:
 * http://www-128.ibm.com/developerworks/java/library/j-2dswt/?ca=dgr-jw17j-2dswt
 * 
 * @author Yannick Saillet / IBM
 */

public class Graphics2DRenderer {
	private static final PaletteData PALETTE_DATA = new PaletteData(0xFF0000,
			0xFF00, 0xFF);

	private BufferedImage awtImage;

	private Image swtImage;

	private ImageData swtImageData;

	private int[] awtPixels;

	/** RGB value to use as transparent color */
	private static final int TRANSPARENT_COLOR = 0x123456;

	/**
	 * Prepare to render on a SWT graphics context.
	 * 
	 * @param gc
	 */
	public void prepareRendering(GC gc) {
		org.eclipse.swt.graphics.Rectangle clip = gc.getClipping();
		prepareRendering(clip.x, clip.y, clip.width, clip.height);
	}

	/**
	 * Prepare the AWT off screen image for the rendering of the rectangular
	 * region given as parameter.
	 * 
	 * @param clipX
	 * @param clipY
	 * @param clipW
	 * @param clipH
	 */
	public void prepareRendering(int clipX, int clipY, int clipW, int clipH) {
		// check that the off screen images are initialized and large enough
		checkOffScreenImages(clipW, clipH);
		// fill the region in the AWT image with the transparent color
		java.awt.Graphics awtGraphics = awtImage.getGraphics();
		awtGraphics.setColor(new java.awt.Color(TRANSPARENT_COLOR));
		awtGraphics.fillRect(clipX, clipY, clipW, clipH);
	}

	/**
	 * Returns the Graphics2D context to use.
	 * 
	 * @return Graphics2D
	 */
	public Graphics2D getGraphics2D() {
		if (awtImage == null)
			return null;
		return (Graphics2D) awtImage.getGraphics();
	}

	/**
	 * Complete the rendering by flushing the 2D renderer on a SWT graphical
	 * context.
	 * 
	 * @param gc
	 */
	public void render(GC gc) {
		if (awtImage == null)
			return;

		org.eclipse.swt.graphics.Rectangle clip = gc.getClipping();
		transferPixels(clip.x, clip.y, clip.width, clip.height);
		gc.drawImage(swtImage, clip.x, clip.y, clip.width, clip.height, clip.x,
				clip.y, clip.width, clip.height);
	}

	/**
	 * Transfer a rectangular region from the AWT image to the SWT image.
	 */
	private void transferPixels(int clipX, int clipY, int clipW, int clipH) {
		int step = swtImageData.depth / 8;
		byte[] data = swtImageData.data;
		awtImage.getRGB(clipX, clipY, clipW, clipH, awtPixels, 0, clipW);
		for (int i = 0; i < clipH; i++) {
			int idx = (clipY + i) * swtImageData.bytesPerLine + clipX * step;
			for (int j = 0; j < clipW; j++) {
				int rgb = awtPixels[j + i * clipW];
				for (int k = swtImageData.depth - 8; k >= 0; k -= 8) {
					data[idx++] = (byte) ((rgb >> k) & 0xFF);
				}
			}
		}
		if (swtImage != null)
			swtImage.dispose();
		swtImage = new Image(Display.getDefault(), swtImageData);
	}

	/**
	 * Dispose the resources attached to this 2D renderer.
	 */
	public void dispose() {
		if (awtImage != null)
			awtImage.flush();
		if (swtImage != null)
			swtImage.dispose();
		awtImage = null;
		swtImageData = null;
		awtPixels = null;
	}

	/**
	 * Ensure that the off screen images are initialized and are at least as
	 * large as the size given as parameter.
	 */
	private void checkOffScreenImages(int width, int height) {
		int currentImageWidth = 0;
		int currentImageHeight = 0;
		if (swtImage != null) {
			currentImageWidth = swtImage.getImageData().width;
			currentImageHeight = swtImage.getImageData().height;
		}

		// if the off screen images are too small, recreate them
		if (width > currentImageWidth || height > currentImageHeight) {
			dispose();
			width = Math.max(width, currentImageWidth);
			height = Math.max(height, currentImageHeight);
			awtImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);
			swtImageData = new ImageData(width, height, 24, PALETTE_DATA);
			swtImageData.transparentPixel = TRANSPARENT_COLOR;
			awtPixels = new int[width * height];
		}
	}
}
