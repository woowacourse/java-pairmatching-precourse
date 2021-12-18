package pairmatching.controller;

import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private PairMatching pairMatching = new PairMatching();
	private OutputView outputView = new OutputView(pairMatching);
	public PairMatchingController() {
	}

	public void run() {
		inputMainMenu();
	}

	private void inputMainMenu() {
		outputView.printMainMenu();
		InputView.inputMainMenu();
	}
}
