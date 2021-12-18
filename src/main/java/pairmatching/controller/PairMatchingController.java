package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	public void run() {
		inputView.enterRoleNumber();
		outputView.printCourseAndMission();
	}
}
