package pairmatching.view;

import pairmatching.processor.InputProcessor;
import pairmatching.processor.OutputProcessor;

public abstract class CommonView {
	protected final InputProcessor inputProcessor = new InputProcessor();
	protected final OutputProcessor outputProcessor = new OutputProcessor();
	private ViewState viewState;

	public CommonView() {
		this.viewState = ViewState.SHOW;
	}

	public void hide() {
		this.viewState = ViewState.HIDE;
	}

	public boolean isShow() {
		return viewState.isShow();
	}

	public abstract void show();
}
