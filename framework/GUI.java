package framework;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * 
 * A class to create the main window
 *
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = -1893717094378742208L;

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 * 
	 * @param p
	 *            The presenter to execute actions
	 * @param tb
	 *            The menu to use in the main window
	 */
	public GUI(Presenter p, ToolBox tb) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(tb.getMenuBar());
		JLabel label = new JLabel("", SwingConstants.CENTER);
		this.setPreferredSize(new Dimension(500, 500));
		p.setLabel(label);
		this.add(new JScrollPane(label));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
