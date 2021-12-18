package pairmatching.controller;

import pairmatching.view.InputView;

public class PairMatchingController {

	FunctionController functionController = new FunctionController();

	public void run() {
		String function = InputView.printMainMenu();
		functionController.choiceFunction(function);
	}
}
