package app;

import framework.GUI;

public class GUIDemo {
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI gui = new GUI(new ImagePresenter(), new ImageEditor());
			}
		});
	}

}
