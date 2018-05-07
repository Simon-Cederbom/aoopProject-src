package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import framework.Edit;

public class OnlyRed extends Edit {

	public BufferedImage edit(BufferedImage img) {

		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				img.setRGB(x, y, (new Color(1, 0, 0).getRGB()) * (img.getRGB(x, y)));
			}
		}

		return img;
	}

}
