package framework;

import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import app.ImageEditor;
import app.ImagePresenter;

public class GUI extends JFrame {

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	public GUI(Presenter p, Editor editor) {
		JFrame frame = new JFrame("Image Processing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar((new ToolBox(p, editor)).getMenuBar());
		JLabel label = new JLabel("", SwingConstants.CENTER);
		frame.setPreferredSize(new Dimension(500,500));
		((ImagePresenter) p).setLabel(label);
		frame.add(new JScrollPane(label));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
