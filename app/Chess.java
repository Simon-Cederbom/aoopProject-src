package app;

import java.awt.Color;
import java.awt.image.BufferedImage;

import framework.Edit;


public class Chess extends Edit {

	public BufferedImage edit(BufferedImage img) {

		boolean white = true;

		for (int x = 0; x < img.getWidth(); x++) {
			if (x % (img.getWidth() / 8) == 0 && x > img.getWidth() % 8 && x < img.getWidth() - img.getWidth() % 8) {
				white = !white;
			}
			for (int y = 0; y < img.getHeight(); y++) {
				if (y % (img.getHeight() / 8) == 0 && y > img.getHeight() % 8
						&& y < img.getHeight() - img.getHeight() % 8) {
					white = !white;
				}
				if (white) {
					img.setRGB(x, y, new Color(img.getRGB(x, y)).brighter().getRGB());

				} else
					img.setRGB(x, y, new Color(img.getRGB(x, y)).darker().getRGB());
			}
			white = !white; //Byter f�rg igen f�r att n�r den slutar p� svart p� en rad s� ska den b�rja med vit p� n�sta
		}

		return img;
	}

}

// Fungerar f�r att g�ra ett rutm�nster men vet ej om det �r uppgiften.

// Graphics g = img.getGraphics();
// g.setColor(new Color(0, 0, 0));
//
// for (int x = 0; x < img.getWidth(); x++) {
// if (x % (img.getWidth() / 9) == 0 && x > img.getWidth()%9 && x <
// img.getWidth() - img.getWidth()%9) {
// g.fillRect(x, 0, img.getWidth() % 9, img.getHeight());
// x += img.getWidth() % 9;
// }
// }
//
// for (int y = 0; y < img.getHeight(); y++) {
// if (y % (img.getHeight() / 9) == 0 && y > img.getHeight()%9 && y <
// img.getHeight() - img.getHeight()%9) {
// g.fillRect(0, y, img.getWidth(), img.getWidth() % 9);
// y += img.getHeight() % 9;
// }
// }