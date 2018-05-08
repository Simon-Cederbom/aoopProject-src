package app;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import framework.ScaleableEdit;

public class Brightness extends ScaleableEdit{

	public BufferedImage edit(BufferedImage img, int scale) {
		
		float floatScale = scale;
		
		RescaleOp rescaleOp = new RescaleOp(floatScale * 100, 15, null);
		rescaleOp.filter(img, img);
		
		return img;
	}
}
