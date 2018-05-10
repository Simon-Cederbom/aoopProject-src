package app;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import java.awt.image.RescaleOp;

import framework.ScaleableEdit;

public class Brightness extends ScaleableEdit {

	public BufferedImage edit(BufferedImage img, int scale) {

		if (img.getColorModel().getColorSpace().getType() == ColorSpace.CS_GRAY) {
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			op.filter(img, null);

			float floatScale = (scale + (float) 39.99899) / ((float) 100);
			RescaleOp rescaleOp = new RescaleOp(floatScale, 15, null);
			rescaleOp.filter(img, img);

			cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			op = new ColorConvertOp(cs, null);
			op.filter(img, null);
			
		} else {
			float floatScale = (scale + (float) 39.99899) / ((float) 100);
			RescaleOp rescaleOp = new RescaleOp(floatScale, 15, null);
			rescaleOp.filter(img, img);
		}

		return img;
	}
}
