package app;

import framework.Edit;
import framework.Editor;

public class ImageEditor extends Editor{

	public Edit[] getEdits() {
		Edit[] edits = { new NoRed(), new NoBlue() };

		return edits;

	}
}
