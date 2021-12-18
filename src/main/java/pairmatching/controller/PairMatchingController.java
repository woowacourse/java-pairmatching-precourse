package pairmatching.controller;

import pairmatching.domain.CrewMaker;
import pairmatching.view.InputView;

public class PairMatchingController {

	public void run() {
		CrewMaker.run();
		String menu = getFunctionMenuInput();
	}

	private String getFunctionMenuInput() {
		return InputView.getFunctionMenuInput();
	}

}
