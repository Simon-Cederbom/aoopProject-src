package app;

import java.awt.Color;
import java.awt.image.BufferedImage;

import framework.Edit;

/**
 * 
 * A filter to remove the blue color from an image
 *
 */
public class NoBlue extends Edit {
	
	/**
	 * Removes the blue color from the image
	 * 
	 * @param obj The object to be changed
	 * 
	 * @return The filtered object
	 */
	public Object edit(Object obj) {

		BufferedImage img = (BufferedImage)obj;

		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				img.setRGB(x, y, (new Color(new Color(img.getRGB(x,y)).getRed(),new Color(img.getRGB(x,y)).getGreen() , 0).getRGB()));
			}
		}

		return img;
	}
	
}
