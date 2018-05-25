package framework;

import javax.swing.JLabel;

public abstract class Presenter {

	public abstract void setLabel(JLabel label);

	public abstract void openFile();

	public abstract void saveFile();

	public abstract void reset();

	public abstract void undo();

	public abstract void redo();

	public abstract void setEdit(ScalableEdit edit, int scale);

	public abstract void sliderReleased(ScalableEdit e, int scale);

	public abstract void setEdit(Edit edit);

	public abstract void about();

	public abstract void help();

}