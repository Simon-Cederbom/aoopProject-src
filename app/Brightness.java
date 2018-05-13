package app;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import framework.ScaleableEdit;

public class Brightness extends ScaleableEdit {

	public BufferedImage edit(BufferedImage img, int scale) {

		float floatScale = (scale + (float) 39.99899) / ((float) 100);
		RescaleOp rescaleOp = new RescaleOp(floatScale, 15, null);
		return rescaleOp.filter(img, null);
	}
}
