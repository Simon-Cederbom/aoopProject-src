
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Filters {

	public static BufferedImage noRed(BufferedImage img) {

		for (int y = 0; y < img.getHeight(); ++y) {
			for (int x = 0; x < img.getWidth(); ++x) {
				img.setRGB(x, y, (new Color(255, 255, 255, 0).getRGB())*(img.getRGB(x, y)));
			}
		}

		return img;
	}

}
