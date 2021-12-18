package controller;

import view.InputDisplay;

public class MatchingController {

	private MatchingController() {
	}

	public static void runMatchingProgram() {
		InputDisplay.askInputFunctionSelectionNumber();
		InputController.inputFunctionSelectionNumber();
	}
}
