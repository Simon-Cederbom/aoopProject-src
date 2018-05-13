package framework;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;

public class ToolBox extends JMenuBar {

	private ArrayList<Edit> edits = new ArrayList<Edit>();
	private ArrayList<ScaleableEdit> scaleableEdits = new ArrayList<ScaleableEdit>();
	
	private JMenuBar menuBar;
	private JMenu fileMenu, filterMenu, subMenu;
	private JMenuItem menuItem;
	private KeyStroke keyStrokeToOpen;

	public JMenuBar getMenuBar(){
		return this.menuBar;
	}

	public ToolBox(Presenter p, Editor editor) {

		for (Edit e : editor.getEdits()) {
			edits.add(e);
		}
		for (ScaleableEdit e : editor.getScaleableEdits()) {
			scaleableEdits.add(e);
		}

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		filterMenu = new JMenu("Filters");
		filterMenu.setMnemonic(KeyEvent.VK_I);
		menuBar.add(filterMenu);

		menuItem = new JMenuItem("Open File");
		menuItem.setMnemonic(KeyEvent.VK_O);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToOpen);
		menuItem.addActionListener(e -> {
			p.openFile();
		});
		fileMenu.add(menuItem);

		menuItem = new JMenuItem("Save File");
		menuItem.setMnemonic(KeyEvent.VK_S);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToOpen);
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
			menuItem = new JMenuItem(edit.getClass().getName().substring(4));
			menuItem.addActionListener(a -> {
				p.setEdit(edit);
			});
			subMenu.add(menuItem);
		}
		
		for (ScaleableEdit edit : scaleableEdits) {
			JSlider slider = new JSlider(JSlider.HORIZONTAL);
			menuItem = new JMenuItem(edit.getClass().getName().substring(4));
			menuItem.addActionListener(a -> {
				p.setEdit(edit, slider.getValue());
				slider.setValue(50);
			});
			subMenu.add(menuItem);
			subMenu.add(slider);
		}
		filterMenu.add(subMenu);
		
		menuItem = new JMenuItem("Undo");
		menuItem.setMnemonic(KeyEvent.VK_Z);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToOpen);
		menuItem.addActionListener(e -> {
			p.undo();
		});
		filterMenu.add(menuItem);
		
		menuItem = new JMenuItem("Redo");
		menuItem.setMnemonic(KeyEvent.VK_Y);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToOpen);
		menuItem.addActionListener(e -> {
			p.redo();
		});
		filterMenu.add(menuItem);
		
		menuItem = new JMenuItem("Reset");
		menuItem.setMnemonic(KeyEvent.VK_R);
		keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(keyStrokeToOpen);
		menuItem.addActionListener(e -> {
			p.reset();
		});
		filterMenu.add(menuItem);

	}

}
