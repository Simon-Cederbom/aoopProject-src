package app;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import framework.Edit;

/**
 * 
 * A filter to flip an image horizontally
 * 
 */
public class FlipX extends Edit {

	/**
	 * Flips the image horizontally
	 * 
	 * @param img The image to be changed
	 * 
	 * @return The filtered image
	 */
	public BufferedImage edit(BufferedImage img) {

		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-img.getWidth(), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return op.filter(img, null);

	}

}