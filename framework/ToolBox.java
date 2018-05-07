package framework;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class ToolBox extends JMenuBar {

	private ArrayList<Edit> edits = new ArrayList<Edit>();
	
	private JMenuBar menuBar;
	private JMenu fileMenu, filterMenu, subMenu;
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
			p.openFile();
		});
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Save Image");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.addActionListener(a -> {
			p.saveFile();
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.addActionListener(a -> {
			System.exit(0);
		});
		fileMenu.add(menuItem);
		
		subMenu = new JMenu("Filters");

		for (Edit edit : edits) {
			menuItem = new JMenuItem("" + edit.getClass().getName().substring(4));
			menuItem.addActionListener(a -> {
				p.setEdit(edit);
			});
			subMenu.add(menuItem);
		}
		
		filterMenu.add(subMenu);
		
		menuItem = new JMenuItem("Undo");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.addActionListener(e -> {
			p.undo();
		});
		filterMenu.add(menuItem);
		
		menuItem = new JMenuItem("Reset");
		menuItem.setMnemonic(KeyEvent.VK_R);
		menuItem.addActionListener(e -> {
			p.reset();
		});
		filterMenu.add(menuItem);

	}

}
