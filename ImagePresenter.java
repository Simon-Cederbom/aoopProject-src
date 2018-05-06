import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePresenter extends Presenter {

	private BufferedImage img;
	private JLabel imagelabel;
	private JLabel label;
	final JFileChooser fc = new JFileChooser();

	public ImagePresenter() {
		imagelabel = createCenterComponent();
	}

	public void setLabel(JLabel l) {
		label = l;
	}

	public void showImage(File file) {
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException("File could not be opened");
		}
		label.setIcon(new ImageIcon(img));
		label.repaint();
	}

	public JLabel createCenterComponent() {
		JLabel l = new JLabel();
		l.setPreferredSize(new Dimension(100, 200));
		return l;
	}

	public void openFile() {
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			showImage(file);
			System.out.println(file);
		}
	}

	public void saveFile() {
		// TODO
	}

	public JLabel getImageLabel() {
		return imagelabel;
	}

	public void actionPerformed(ActionEvent e) {
		openFile();
		// TODO Fixa AE för saveFile
	}
}
