package pairmatching.controller;

import pairmatching.view.InputView;

public class MatchingController {
	public void start() {
		InputController inputController = new InputController();
		String inputNum = inputController.scanSelectFunction();
		if (inputNum.equals("1") || inputNum.equals("2")) {
			InputView.askCourseLevelMission();
			inputController.scanCourseLevelMission();
		}
	}
}
