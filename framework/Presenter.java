package framework;


public abstract class Presenter {

	public abstract void openFile();

	public abstract void saveFile();
	
	public abstract void reset();
	
	public abstract void undo();
	
	public abstract void redo();
	
	public abstract void setEdit(ScaleableEdit edit, int scale);
	
	public abstract void setEdit(Edit edit);
	
	public abstract void about();
	
	public abstract void help();
	
}