package app;

import framework.ImageEdit;

public class ImageEditor {

	public ImageEdit[] getFilters() {
		ImageEdit[] filters = { new NoRed() };

		return filters;

	}
}
