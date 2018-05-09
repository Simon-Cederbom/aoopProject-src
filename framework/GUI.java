package framework;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.ImageEditor;
import app.ImagePresenter;

public class GUI extends JFrame {

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private GUI(Presenter p, Editor editor) {
		JFrame frame = new JFrame("Image Processing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar((new ToolBox(p, editor)).getMenuBar());
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(500, 500));
		((ImagePresenter) p).setLabel(label);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI gui = new GUI(new ImagePresenter(), new ImageEditor());
			}
		});
	}
}
