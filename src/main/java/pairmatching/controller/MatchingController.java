package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private final InputView inputView;
	private final OutputView outputView;

	public MatchingController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		outputView.printCoursesAndMissions();
	}

}
