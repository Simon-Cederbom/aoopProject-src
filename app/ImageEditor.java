package app;

import framework.Edit;
import framework.Editor;
import framework.ScaleableEdit;

public class ImageEditor extends Editor{

	public Edit[] getEdits() {
		Edit[] edits = { new OnlyRed(), new NoBlue(), new Greyscale(), new FlipX(), new Stripes(), new Circle(), new Chess() };

		return edits;

	}
	
	public ScaleableEdit[] getScaleableEdits(){
		ScaleableEdit[] edits = {new Swirl(), new Brightness()};
		
		return edits;
	}
}
