package framework;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class ToolBox extends JMenuBar {

	private ArrayList<Edit> edits = new ArrayList<Edit>();
	
	private JMenuBar menuBar;
	private JMenu fileMenu, filterMenu;
	private JMenuItem menuItem;

	public JMenuBar getMenuBar(){
		return this.menuBar;
	}

	public ToolBox(Presenter p, Editor editor) {

		for (Edit e : editor.getEdits()) {
			edits.add(e);
		}

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		filterMenu = new JMenu("Filters");
		filterMenu.setMnemonic(KeyEvent.VK_I);
		menuBar.add(filterMenu);

		menuItem = new JMenuItem("Open Image");
		menuItem.setMnemonic(KeyEvent.VK_O);
		menuItem.addActionListener(e -> {
			p.openImage();
		});
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Save Image");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(a -> {
			p.saveFile();
		});
		fileMenu.add(menuItem);

		for (Edit edit : edits) {
			menuItem = new JMenuItem("" + edit.getClass().getName().substring(4));
			menuItem.addActionListener(a -> {
				p.setEdit(edit);
			});
			filterMenu.add(menuItem);
		}
		
		menuItem = new JMenuItem("Reset Image");
		menuItem.setMnemonic(KeyEvent.VK_R);
		menuItem.addActionListener(e -> {
			p.resetImage();
		});
		filterMenu.add(menuItem);

	}

}
