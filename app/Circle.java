package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Edit;

/**
 * 
 * A filter to create a black filled circle on top of an image
 *
 */
public class Circle extends Edit {

	/**
	 * 
	 * Creates a circle on top of the image
	 * 
	 * @param obj The object to be changed
	 * 
	 * @return The filtered object
	 */
	public Object edit(Object obj) {

		BufferedImage img = (BufferedImage)obj;

		Graphics g = img.getGraphics();
		g.setColor(new Color(20, 20, 20));
		g.fillArc(0, img.getHeight()/2 - img.getWidth()/2, img.getWidth(), img.getWidth(), 0, 360);	
	
		return img;
	}

}
