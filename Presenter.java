import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public abstract class Presenter extends JApplet implements ActionListener{
	
	public abstract JComponent createCenterComponent();

	public void showText(String text) {
	}

	public abstract void openFile();

	public abstract void saveFile();
	
}