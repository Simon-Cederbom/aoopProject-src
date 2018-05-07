package framework;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class ToolBox extends JMenuBar {

	private ArrayList<Edit> edits = new ArrayList<Edit>();

	public JMenuBar createToolBox(Presenter p, Editor editor) {

		for (Edit e : editor.getEdits()) {
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
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Save image");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(a -> {
		});

		menu.add(menuItem);

		// for(Edit edit : edits){
		// menuItem = new JMenuItem("Test");
		// //menuItem.setMnemonic(KeyEvent.VK_1); //TODO LÄGG TILL KNAPP OCH
		// NAMN I EDIT
		// menuItem.addActionListener(a -> {
		// p.setEdit(edit);
		// });
		// menu2.add(menuItem);
		// }
		//
		menuItem = new JMenuItem("Filter1");
		menuItem.setMnemonic(KeyEvent.VK_1);
		menuItem.addActionListener(a -> {
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
