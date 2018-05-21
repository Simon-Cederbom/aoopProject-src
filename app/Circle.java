package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Edit;

/**
 * 
 * A filter to create a circle on top of an image
 *
 */
public class Circle extends Edit {

	/**
	 * 
	 * Creates a circle on top of the image
	 * 
	 * @param img The image to be changed
	 * 
	 * @return The filtered image
	 */
	public BufferedImage edit(BufferedImage img) {

		Graphics g = img.getGraphics();
		g.setColor(new Color(20, 20, 20));
		g.fillArc(0, img.getHeight()/2 - img.getWidth()/2, img.getWidth(), img.getWidth(), 0, 360);	
	
		return img;
	}

}
