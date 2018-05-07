package app;

import framework.Edit;
import framework.Editor;

public class ImageEditor extends Editor{

	public Edit[] getEdits() {
		Edit[] edits = { new OnlyRed(), new NoBlue(), new Greyscale(), new FlipX() };

		return edits;

	}
}
