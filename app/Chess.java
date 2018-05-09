package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import framework.Edit;

/*TODO
 * Kanske inte s�h�r de menar med chessfilter. 
 */

public class Chess extends Edit {

	public BufferedImage edit(BufferedImage img) {

		Graphics g = img.getGraphics();
		g.setColor(new Color(0, 0, 0));
		
		for (int x = 0; x < img.getWidth(); x++) {
			if (x % (img.getWidth() / 11) == 0 && x > img.getWidth()%11 && x < img.getWidth() - img.getWidth()%11) {
				g.fillRect(x, 0, img.getWidth() % 11, img.getHeight());
				x += img.getWidth() % 11;
			}
		}
		
		for (int y = 0; y < img.getHeight(); y++) {
			if (y % (img.getHeight() / 11) == 0 && y > img.getHeight()%11 && y < img.getHeight() - img.getHeight()%11) {
				g.fillRect(0, y, img.getWidth(), img.getWidth() % 11);
				y += img.getHeight() % 11;
			}
		}

		return img;
	}

}
