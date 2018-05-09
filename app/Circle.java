package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Edit;


/* TODO
 * Circle kommer inte i mittan av Y-led
 */
public class Circle extends Edit {

	public BufferedImage edit(BufferedImage img) {

		Graphics g = img.getGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillArc(0, /*DENNA STÄMMER EJ*/ img.getHeight() - img.getWidth()/2, img.getWidth(), img.getWidth(), 0, 360);	
		
		
		g.setColor(new Color(255, 255, 255));
		g.drawString("KÅGE FIXA DENNA!", img.getWidth()/2 , img.getHeight()/2);
		
		
		return img;
	}

}
