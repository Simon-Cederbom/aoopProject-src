package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import framework.Edit;

public class OnlyRed extends Edit {

	public BufferedImage edit(BufferedImage img) {

		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				img.setRGB(x, y, new Color(new Color(img.getRGB(x, y)).getRed(), 0, 0).getRGB());
			}
		}

		return img;
	}

}
