package app;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import framework.ScalableEdit;

/**
 * 
 * A filter that swirls an image
 *
 */
public class Swirl extends ScalableEdit {

	
	/*TODO
	 *  Use bilinear interpolation to get the color to get rid of the noise.
	 */
	/**
	 * Swirls the image
	 * 
	 * @param img The image to be changed
	 * @param scale A value to choose how much the image should swirl and in what direction
	 * 
	 * @return The filtered image
	 */
	public BufferedImage edit(BufferedImage img, int scale) {
		
		double scaleDouble = (scale - 50) / ((double) 10000);
		int width  = img.getWidth();
        int height = img.getHeight();
        BufferedImage pic2 = new BufferedImage(width, height, img.getType());
        double x0 = 0.5 * (width  - 1);
        double y0 = 0.5 * (height - 1);
		for (int sx = 0; sx < width; sx++) {
            for (int sy = 0; sy < height; sy++) {
                double dx = sx - x0;
                double dy = sy - y0;
                double r = Math.sqrt(dx*dx + dy*dy);
                double angle = scaleDouble * r;
                int tx = (int) (+dx * Math.cos(angle) - dy * Math.sin(angle) + x0);
                int ty = (int) (+dx * Math.sin(angle) + dy * Math.cos(angle) + y0);

                if (tx >= 0 && tx < width && ty >= 0 && ty < height)
                    pic2.setRGB(sx, sy, img.getRGB(tx, ty));
                else pic2.setRGB(sx, sy, img.getTransparency());
            }
        }
		return pic2;
	}
	
	static BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
