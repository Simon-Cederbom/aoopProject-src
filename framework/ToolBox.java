package framework;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class ToolBox {
	
	ArrayList<Edit> edits = new ArrayList<Edit>();

	public static JMenuBar createMenuBar(Presenter p , Editor editor) {
		
		for(Edit e : editor.getEdits()){
			edits.add(e);
		}
		
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

		menuItem = new JMenuItem("Save image");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(a -> {
			p.saveFile();
		});

		menu.add(menuItem);

		menuItem = new JMenuItem("Filter1");
		menuItem.setMnemonic(KeyEvent.VK_1);
		menuItem.addActionListener(a -> {
			p.setFilter("noRed");
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
