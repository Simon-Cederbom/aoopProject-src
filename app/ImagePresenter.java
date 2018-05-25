package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import framework.Edit;
import framework.Presenter;
import framework.ScalableEdit;

/**
 * 
 * A class which controls all actions connected to an image
 *
 */
public class ImagePresenter extends Presenter {

	private Stack<BufferedImage> imgStack = new Stack<BufferedImage>();
	private BufferedImage redo = null;
	private BufferedImage copy = null;

	private JLabel label;
	private final JFileChooser fc = new JFileChooser();

	/**
	 * Sets the private label
	 * 
	 * @param l
	 *            The label to set the private label to
	 */
	public void setLabel(JLabel l) {
		label = l;
	}

	/**
	 * Shows the image
	 * 
	 * @param img
	 *            The image to be shown
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
				copy = deepCopy(imgStack.peek());
				showImage(imgStack.peek());
			} catch (Exception e) {
				JFrame frame = new JFrame("Error");
				JLabel l = new JLabel("", SwingConstants.CENTER);
				l.setText("<html><b>File could not be opened!</html>");
				l.setPreferredSize(new Dimension(300, 50));
				JButton okbutton = new JButton("Ok");
				okbutton.addActionListener(ae -> {
					frame.dispose();
					this.openFile();
				});
				frame.setLayout(new BorderLayout());
				frame.add(l, BorderLayout.NORTH);
				frame.add(okbutton, BorderLayout.SOUTH);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		}

	}

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
	 * @param e
	 *            The scalable filter to be used
	 * @param scale
	 *            A value which determines how much the filter should affect the
	 *            image
	 */
	public void setEdit(ScalableEdit e, int scale) {
		showImage((BufferedImage) e.edit(copy, scale));
	}

	/**
	 * Pushes the current image to the stack
	 * 
	 * @param e
	 *            The scalable filter to be used
	 * @param scale
	 *            A value which determines how much the filter should affect the
	 *            image
	 * 
	 */
	public void sliderReleased(ScalableEdit e, int scale) {
		copy = (BufferedImage) e.edit(deepCopy(copy), scale);
		imgStack.push(deepCopy(copy));
		showImage(imgStack.peek());
	}

	/**
	 * Applies a filter to the current image
	 * 
	 * @param e
	 *            The filter to be used
	 */
	public void setEdit(Edit e) {
		imgStack.push((BufferedImage) e.edit(deepCopy(imgStack.peek())));
		copy = deepCopy(imgStack.peek());
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
		copy = deepCopy(imgStack.peek());
		showImage(imgStack.peek());
	}

	/**
	 * Removes the last change to the image
	 * 
	 */
	public void undo() {
		if (imgStack.size() > 1) {
			redo = deepCopy(imgStack.peek());
			if (imgStack.size() > 1) {
				imgStack.pop();
			}
			copy = deepCopy(imgStack.peek());
			showImage(imgStack.peek());
		}
	}

	/**
	 * Applies the last removed change to the image
	 * 
	 */
	public void redo() {
		if (redo != null) {
			imgStack.push(redo);
			copy = deepCopy(imgStack.peek());
			showImage(imgStack.peek());
		}
	}

	/**
	 * Copies an image
	 * 
	 * @param bi
	 *            The image to be copied
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
		l.setText(
				"<html>Version: 7.7<br/><br/>Authors: Filip Kågesson, Simon Cederbom<br/><br/>This program was created as a project in the course<br/>Advanced Object Oriented Programming at Halmstad University</html>");
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
		l.setText(
				"<html>How to use files:<br/><br/>To open a file navigate to \"File\"->\"Open File\" or use Ctrl-O and choose the file you want to use.<br/>To save a file navigate to \"File\"->\"Save File\" or use Ctrl-S and choose the name you want the file to have.<br/>You can exit the program by navigating to \"File\"->\"Exit\".<br/><br/>How to use filters:<br/><br/>Navigate to \"Filters\"->\"Filters\" and find the filter you want to use in the menu.<br/>If the filter doesn't include a slider below the name you can just press the name to apply the filter.<br/>If the filter includes a slider below the name you just have to drag the slider and when you release the slider the filter will be applied.<br/>In order to restore the image to a previous state you can navigate to \"Filters\"->\"Undo\" or use Ctrl-Z and you will get the image without the latest filter applied.<br/>In order to reapply the latest change removed by using \"Undo\" you can navigate to \"Filters\"->\"Redo\" or use Ctrl-Y and the change will be reapplied.<br/>Navigate to \"Filters\"->\"Reset\" or use Ctrl-R to restore the image to the source image.<br/><br/>Shortcuts:<br/>Alt-F: Opens the \"File\"-menu<br/>Alt-I: Opens the \"Filters\"-menu<br/>Alt-H: Opens the \"Help\"-menu<br/>Ctrl-O: Opens a new file<br/>Ctrl-S: Saves the current file<br/>Ctrl-Z: Undo<br/>Ctrl-Y: Redo<br/>Ctrl-R: Restore</html>");
		frame.add(l);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
