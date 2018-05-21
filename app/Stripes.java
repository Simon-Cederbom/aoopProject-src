package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Edit;


/**
 * 
 * A filter that creates stripes on top of an image
 *
 */
public class Stripes extends Edit {

	/**
	 * Creates stripes on top of the image
	 * 
	 * @param img The image to be changed
	 * 
	 * @return The filtered image
	 */
	public BufferedImage edit(BufferedImage img) {

		boolean black = false;

		for (int x = 0; x < img.getWidth(); x++) {
			if (x % (img.getWidth() / 21) == 0 && x > img.getWidth() % 21 && x < img.getWidth() - img.getWidth() % 21) {
				black = !black;
			}
			for (int y = 0; y < img.getHeight(); y++) {
				if(black){
					img.setRGB(x, y, new Color(20,20,20).getRGB());
				}
			}
		}

		return img;
	}

}
