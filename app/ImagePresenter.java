package app;

import java.awt.Dimension;
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

/**
 * 
 * A class which controls all actions connected to an image
 *
 */
public class ImagePresenter extends Presenter {

	private Stack<BufferedImage> imgStack = new Stack<BufferedImage>();
	private BufferedImage redo = null;

	private JLabel label;
	private final JFileChooser fc = new JFileChooser();

	/**
	 * Sets the private label
	 * 
	 * @param l The label to set the private label to
	 */
	public void setLabel(JLabel l) {
		label = l;
	}

	/**
	 * Shows the image
	 * 
	 * @param img The image to be shown
	 */
	public void showImage(BufferedImage img) {
		label.setIcon(new ImageIcon(img));
		label.repaint();
	}

	/**
	 * Opens a file chosen by the user
	 * 
	 */
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
	/**
	 * Saves the current file
	 * 
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

	/**
	 * Applies a filter to the current image
	 * 
	 * @param e The scalable filter to be used
	 * @param scale A value which determines how much the filter should affect the image
	 */
	public void setEdit(ScaleableEdit e, int scale) {
		imgStack.push(e.edit(deepCopy(imgStack.peek()), scale));
		showImage(imgStack.peek());
	}

	/**
	 * Applies a filter to the current image
	 * 
	 * @param e The filter to be used
	 */
	public void setEdit(Edit e) {
		imgStack.push(e.edit(deepCopy(imgStack.peek())));
		showImage(imgStack.peek());
	}

	/**
	 * Resets the image to the original version
	 * 
	 */
	public void reset() {
		redo = deepCopy(imgStack.peek());
		while (imgStack.size() > 1) {
			imgStack.pop();
		}
		showImage(imgStack.peek());
	}

	/**
	 * Removes the last change to the image
	 * 
	 */
	public void undo() {
		redo = deepCopy(imgStack.peek());
		if (imgStack.size() > 1) {
			imgStack.pop();
		}
		showImage(imgStack.peek());
	}

	/**
	 * Applies the last removed change to the image
	 * 
	 */
	public void redo() {
		if (redo != null) {
			imgStack.push(redo);
			showImage(imgStack.peek());
		}
	}

	/**
	 * Copies an image
	 * 
	 * @param bi The image to be copied
	 * @return The copy of the image
	 */
	static BufferedImage deepCopy(BufferedImage bi) {
		ColorModel cm = bi.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = bi.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	/**
	 *
	 * Shows a new window with information
	 * 
	 */
	public void about() {
		JFrame frame = new JFrame("About");
		JLabel l = new JLabel();
		l.setText("<html>Version: 7.0<br/><br/>Authors: Filip Kågesson, Simon Cederbom</html>");
		l.setPreferredSize(new Dimension(300,100));
		frame.add(l);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * Shows a new window with information on how to use the system
	 * 
	 */
	public void help() {
		JFrame frame = new JFrame("Help");
		JLabel l = new JLabel();
		l.setText("<html>Using filters:<br/>Find the filter you want to use in the filter menu. To use the filter you just press the filter if it's not a scalable filter. If the filter is scalable you have to set the slider before you press the filter</html>");
		l.setPreferredSize(new Dimension(300,100));
		frame.add(l);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
