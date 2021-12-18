package pairmatching.controller;

import pairmatching.view.InputView;

public class PairMatchingController {

	FunctionController functionController = new FunctionController();

	public void run() {
		String menuChoice = "0";
		while (menuChoice != "Q") {
			menuChoice = InputView.printMainMenu();
			functionController.choiceFunction(menuChoice);
		}

	}
}
