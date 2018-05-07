package app;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import framework.Edit;
import framework.Presenter;

public class ImagePresenter extends Presenter {

	private BufferedImage originalImg;
	private BufferedImage img;
	private JLabel label;
	final JFileChooser fc = new JFileChooser();

	public void setLabel(JLabel l) {
		label = l;
	}

	public BufferedImage getImage() {
		return this.img;
	}

	public void setImage(BufferedImage img) {
		this.img = img;
	}

	public void showImage(File file) {
		try {
			img = ImageIO.read(file);
			label.setIcon(new ImageIcon(img));
			label.repaint();
		} catch (IOException e) {
			throw new RuntimeException("File could not be opened");
		}
	}

	public void showImage(BufferedImage img) {
		label.setIcon(new ImageIcon(img));
		label.repaint();
	}

	public void openImage() {
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				img = ImageIO.read(file);
				originalImg = deepCopy(img);
				showImage(img);
			} catch (IOException e) {
				throw new RuntimeException("File could not be opened");
			}
		}
	}

	// TODO Fixa så man slipper skriva vilket filnamn man ska spara som.
	// "testImg.jpg" ska bli "testImg"
	public void saveFile() {
		int saveValue = fc.showSaveDialog(null);
		if (saveValue == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write(img, "png", fc.getSelectedFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setEdit(Edit e) {
		this.img = e.edit(img);
		showImage(img);
	}

	public void resetImage() {
		img = deepCopy(originalImg);
		showImage(img);
	}
	
	public void undoImage() {
		
		showImage(img);
	}

	static BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
