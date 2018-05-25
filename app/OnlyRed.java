package app;

import java.awt.Color;
import java.awt.image.BufferedImage;

import framework.Edit;

/**
 * 
 * A filter that removes all colors except red from an image
 *
 */
public class OnlyRed extends Edit {

	/**
	 * Removes all colors except red from the image
	 * 
	 * @param obj The object to be changed
	 * 
	 * @return The filtered object
	 */
	public Object edit(Object obj) {

		BufferedImage img = (BufferedImage)obj;

		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				img.setRGB(x, y, new Color(new Color(img.getRGB(x, y)).getRed(), 0, 0).getRGB());
			}
		}

		return img;
	}

}
