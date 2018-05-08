package app;

import java.awt.image.BufferedImage;

import framework.Edit;

public class Swirl extends Edit{

	public BufferedImage edit(BufferedImage img) {
		
		double scale = 0.1;
		final double width = img.getWidth();
		final double height = img.getHeight();
		BufferedImage sImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		for (int x = 0; x < width; x++) {
			double xr = x / width - 0.5;
			for (int y = 0; y < height; y++) {
				double yr = y / height - 0.5;
				double r = Math.sqrt(xr * xr + yr * yr);
				double theta = Math.atan2(yr, xr);
				double theta1 = 50 * scale * r * (0.5 - r) + theta;
				int xs = (int) ((0.5 + (r < 0.5 ? r * Math.cos(theta1) : xr)) * width);
				int ys = (int) ((0.5 + (r < 0.5 ? r * Math.sin(theta1) : yr)) * height);
				sImg.setRGB(xs,ys,img.getRGB(x, y));
			}
		}
		return sImg;
	}
}
