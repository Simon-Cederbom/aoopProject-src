package app;

import framework.Edit;
import framework.Editor;
import framework.ScalableEdit;

/**
 * 
 * A class to keep track of the different filters
 *
 */
public class ImageEditor extends Editor{
	
	/**
	 * Creates an array of all non scalable filters
	 * 
	 * @return An array of all non scalable filters
	 */
	public Edit[] getEdits() {
		Edit[] edits = { new OnlyRed(), new NoBlue(), new Greyscale(), new FlipX(), new Stripes(), new Circle(), new Chess() };

		return edits;

	}
	
	/**
	 * Creates an array of all scalable filters
	 * 
	 * @return An array of all scalable filters
	 */
	public ScalableEdit[] getScalableEdits(){
		ScalableEdit[] edits = {new Swirl(), new Brightness()};
		
		return edits;
	}
}
