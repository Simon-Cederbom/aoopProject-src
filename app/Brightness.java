package app;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import framework.ScalableEdit;

/**
 * A filter to make an image brighter or darker
 *
 */
public class Brightness extends ScalableEdit {

	/**
	 * Makes the image brighter or darker depending on the scale
	 * 
	 * @param obj The object to be changed
	 * @param scale Value to choose how bright/dark the image should be
	 * 
	 * @return The filtered object
	 */
	public Object edit(Object obj, int scale){

		BufferedImage img = (BufferedImage)obj;
		
		float floatScale = (scale + (float) 39.99899) / ((float) 100);
		RescaleOp rescaleOp = new RescaleOp(floatScale, 15, null);
		return rescaleOp.filter(img, null);
	}
}
