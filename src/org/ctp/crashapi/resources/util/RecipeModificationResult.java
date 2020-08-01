package org.ctp.crashapi.resources.util;

public class RecipeModificationResult {

	private boolean loaded, changed;
	private String message;

	public RecipeModificationResult(boolean loaded, boolean changed, String message) {
		setLoaded(loaded);
		setChanged(changed);
		setMessage(message);
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
