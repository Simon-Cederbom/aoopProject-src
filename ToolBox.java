import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ToolBox {

	public static JMenuBar createMenuBar(Presenter p) {
		JMenuBar menuBar;
		JMenu menu, menu2;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);
		menu2 = new JMenu("Filter");
		menu2.setMnemonic(KeyEvent.VK_I);
		menuBar.add(menu2);

		menuItem = new JMenuItem("Open image");
		menuItem.setMnemonic(KeyEvent.VK_O);
		menuItem.addActionListener(e -> {
			p.openFile();
		});
		menu.add(menuItem);
		/* //TODO
		 * menuItem = new JMenuItem("Save image");
		 * menuItem.setMnemonic(KeyEvent.VK_S); menuItem.addActionListener(a ->
		 * { int returnVal = fc.showOpenDialog(fc); if (returnVal ==
		 * JFileChooser.APPROVE_OPTION) { File file = fc.getSelectedFile();
		 * System.out.println("då"); } });
		 */
		menu.add(menuItem);

		menuItem = new JMenuItem("Filter1");
		menuItem.setMnemonic(KeyEvent.VK_1);
		menuItem.addActionListener(a -> {
			System.out.println("Filter1");
		});
		menu2.add(menuItem);

		menuItem = new JMenuItem("Filter2");
		menuItem.setMnemonic(KeyEvent.VK_2);
		menuItem.addActionListener(a -> {
			System.out.println("Filter2");
		});
		menu2.add(menuItem);

		return menuBar;
	}

}
