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

		Graphics g = img.getGraphics();
		g.setColor(new Color(0, 0, 0));
		for (int x = 0; x < img.getWidth(); x++) {
			if (x % (img.getWidth() / 11) == 0 && x > img.getWidth()%11 && x < img.getWidth() - img.getWidth()%11) {
				g.fillRect(x, 0, img.getWidth() % 11, img.getHeight());
				x += img.getWidth() % 11;
			}
		}

		return img;
	}

}
