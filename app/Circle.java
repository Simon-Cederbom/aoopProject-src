package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Edit;

public class Circle extends Edit {

	public BufferedImage edit(BufferedImage img) {

		Graphics g = img.getGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillArc(0, img.getHeight()/2 - img.getWidth()/2, img.getWidth(), img.getWidth(), 0, 360);	
	
		return img;
	}

}
