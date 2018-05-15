package app;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import framework.ScaleableEdit;

/**
 * A filter to make an image brighter or darker
 *
 */
public class Brightness extends ScaleableEdit {

	/**
	 * Makes the image brighter or darker depending on the scale
	 * 
	 * @param img The image to be changed
	 * @param scale Value to choose how bright/dark the image should be
	 * 
	 * @return The filtered image
	 */
	public BufferedImage edit(BufferedImage img, int scale) {

		float floatScale = (scale + (float) 39.99899) / ((float) 100);
		RescaleOp rescaleOp = new RescaleOp(floatScale, 15, null);
		return rescaleOp.filter(img, null);
	}
}
