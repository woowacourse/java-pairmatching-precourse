package pairmatching.view;

import pairmatching.PairMatchingController;
import pairmatching.processor.InputProcessor;
import pairmatching.processor.OutputProcessor;

public abstract class CommonView {
	protected final InputProcessor inputProcessor = new InputProcessor();
	protected final OutputProcessor outputProcessor = new OutputProcessor();
	protected final PairMatchingController pairMatchingController;
	private ViewState viewState;

	public CommonView(PairMatchingController pairMatchingController) {
		this.viewState = ViewState.SHOW;
		this.pairMatchingController = pairMatchingController;
	}

	public void hide() {
		this.viewState = ViewState.HIDE;
	}

	public boolean isShow() {
		return viewState.isShow();
	}

	public abstract void show();
}
