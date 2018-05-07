import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePresenter extends Presenter {

	private BufferedImage img;
	private JLabel label;
	private String filter;
	final JFileChooser fc = new JFileChooser();

	public ImagePresenter() {
		label = createCenterComponent();
	}

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
		} catch (IOException e) {
			throw new RuntimeException("File could not be opened");
		}
		label.setIcon(new ImageIcon(img));
		label.repaint();
		System.out.println("active filter: " + filter);
	}

	public void showImage(BufferedImage img) {
		label.setIcon(new ImageIcon(img));
		label.repaint();
		System.out.println("active filter: " + filter);
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
	//TODO Fixa så man slipper skriva vilket filnamn man ska spara som. "testImg.jpg" ska bli "testImg"
	public void saveFile() {
		int saveValue = fc.showSaveDialog(null);
		if (saveValue == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIO.write(img, "png",fc.getSelectedFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void setFilter(String filter) {
		if (filter.equals("noRed")) {
			this.filter = filter;
			img = Filters.noRed(img);
			showImage(img);
		}

		// TODO fixa typ en array med filteralgoritmer som ska apliceras på
		// bilden.
	}
}
