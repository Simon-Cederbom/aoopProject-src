package app;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;

import framework.Edit;
import framework.Presenter;
import framework.ScaleableEdit;

public class ImagePresenter extends Presenter {

	Stack<BufferedImage> imgStack = new Stack<BufferedImage>();

	private JLabel label;
	final JFileChooser fc = new JFileChooser();

	public void setLabel(JLabel l) {
		label = l;
	}

	public void showImage(BufferedImage img) {
		label.setIcon(new ImageIcon(img));
		label.repaint();
	}

	public void openFile() {
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				imgStack.push(ImageIO.read(file));
				showImage(imgStack.peek());
			} catch (IOException e) {
				throw new RuntimeException("File could not be opened");
			}
		}

	}

	/*
	 * TODO Fixa så man slipper skriva vilket filnamn man ska spara som.
	 * "testImg.jpg" ska bli "testImg"
	 */
	public void saveFile() {
		int saveValue = fc.showSaveDialog(null);
		if (saveValue == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write(imgStack.peek(), "png", fc.getSelectedFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setEdit(ScaleableEdit e, int scale) {
		imgStack.push(e.edit(deepCopy(imgStack.peek()), scale));
		showImage(imgStack.peek());
	}
	
	public void setEdit(Edit e) {
		imgStack.push(e.edit(deepCopy(imgStack.peek())));
		showImage(imgStack.peek());
	}

	public void reset() {
		BufferedImage img = deepCopy(imgStack.peek());
		while (!imgStack.isEmpty()) {
			img = deepCopy(imgStack.pop());
		}
		imgStack.push(deepCopy(img));
		showImage(imgStack.peek());
	}

	public void undo() {
		if (imgStack.size() > 1) {
			imgStack.pop();
		}
		showImage(imgStack.peek());
	}

	static BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

}
