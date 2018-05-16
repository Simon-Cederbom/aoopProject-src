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
	 * @param img The image to be changed
	 * 
	 * @return The filtered image
	 */
	public BufferedImage edit(BufferedImage img) {

		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				img.setRGB(x, y, (new Color(new Color(img.getRGB(x,y)).getRed(),new Color(img.getRGB(x,y)).getGreen() , 0).getRGB()));
			}
		}

		return img;
	}
	
}
