package framework;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.ImagePresenter;

public class GUI extends JFrame {

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private GUI(Presenter p) {
		// Create and set up the window.
		JFrame frame = new JFrame("Image Processing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add contents to the window.
		frame.setJMenuBar(ToolBox.createMenuBar(p));
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(500, 500));
		((ImagePresenter)p).setLabel(label);
		frame.add(label);
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Presenter p = new ImagePresenter();
				GUI gui = new GUI(p);
			}
		});
	}
}