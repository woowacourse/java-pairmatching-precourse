package pairmatching.controller;

import pairmatching.view.InputView;

public class MatchingController {
	public void start() {
		InputController inputController = new InputController();
		String inputNum = inputController.scanSelectFunction();
	}
}
