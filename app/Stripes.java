package app;

import java.awt.image.BufferedImage;

import framework.Edit;

/*TODO
 * Blir en stripe för mycket.
 */

public class Stripes extends Edit {

	public BufferedImage edit(BufferedImage img) {

		int stipes = 10;

		for (int x = 0; x < img.getWidth(); x++) {
			if (x % (img.getWidth() / (stipes + 1)) == 0) {
				for (int y = 0; y < img.getHeight(); y++) {
					img.setRGB(x, y, 0);
				}
			}
		}

		return img;
	}

}
