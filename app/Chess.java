package app;

import java.awt.Color;
import java.awt.image.BufferedImage;

import framework.Edit;

/**
 * A filter to create a chess pattern on top of an image
 *
 */
public class Chess extends Edit {

	/**
	 * Creates a chess pattern on top of the image
	 * 
	 * @param obj The object to be changed
	 * 
	 * @return The filtered object
	 */
	public Object edit(Object obj) {

		BufferedImage img = (BufferedImage)obj;
		boolean white = true;

		for (int x = 0; x < img.getWidth(); x++) {
			if (x % (img.getWidth() / 8) == 0 && x > img.getWidth() % 8 && x < img.getWidth() - img.getWidth() % 8) {
				white = !white;
			}
			for (int y = 0; y < img.getHeight(); y++) {
				if (y % (img.getHeight() / 8) == 0 && y > img.getHeight() % 8
						&& y < img.getHeight() - img.getHeight() % 8) {
					white = !white;
				}
				if (white) {
					img.setRGB(x, y, new Color(img.getRGB(x, y)).brighter().getRGB());

				} else
					img.setRGB(x, y, new Color(img.getRGB(x, y)).darker().getRGB());
			}
			white = !white;
		}

		return img;
	}

}