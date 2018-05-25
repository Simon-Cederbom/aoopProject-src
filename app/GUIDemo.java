package app;

import framework.GUI;
import framework.ToolBox;

/**
 * 
 * A class to run the program
 *
 */
public class GUIDemo {
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImagePresenter ip = new ImagePresenter();
				ToolBox tb = new ToolBox(ip, new ImageEditor());
				GUI gui = new GUI(ip, tb);
				gui.setTitle("Image Manipulation");
			}
		});
	}

}
