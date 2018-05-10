package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import framework.ScaleableEdit;

public class Swirl extends ScaleableEdit {

	
	/*TODO
	 *  Use bilinear interpolation to get the color to get rid of the noise.
	 */
	
	public BufferedImage edit(BufferedImage img, int scale) {

		double scaleDouble = (scale - 50) / ((double) 100);
		final double width = img.getWidth();
		final double height = img.getHeight();
		BufferedImage sImg = deepCopy(img);
		for (int x = 0; x < width; x++) {
			double xr = x / width - 0.5;
			for (int y = 0; y < height; y++) {
				double yr = y / height - 0.5;
				double r = Math.sqrt(xr * xr + yr * yr);
				double theta = Math.atan2(yr, xr);
				double theta1 = 50 * scaleDouble * r * (0.5 - r) + theta;
				int xs = (int) ((0.5 + (r < 0.5 ? r * Math.cos(theta1) : xr)) * width);
				int ys = (int) ((0.5 + (r < 0.5 ? r * Math.sin(theta1) : yr)) * height);
				sImg.setRGB(xs, ys, img.getRGB(x, y));
			}
		}
		
		/*removes some of the noise*/
		for (int x = 1; x < width; x++) {
			for (int y = 1; y < height - 1; y++) {
				if (sImg.getRGB(x, y) == new Color(0, 0, 0).getRGB()) {
					sImg.setRGB(x, y, sImg.getRGB(x - 1, y));
				}
			}
		}
		for (int x = 0; x < width -2; x++) {
			for (int y = 0; y < height - 2; y++) {
				if (sImg.getRGB(x, y) == img.getRGB(x,y)) {
					sImg.setRGB(x, y, sImg.getRGB(x, y+1));
				}
				if (sImg.getRGB(x, y) == img.getRGB(x,y)) {
					sImg.setRGB(x, y, sImg.getRGB(x+1, y));
				}
			}
		}

		return sImg;
	}
	
	static BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
