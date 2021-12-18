package controller;

import view.InputDisplay;
import view.OutputDisplay;

public class MatchingController {

	private MatchingController() {
	}

	public static void runMatchingProgram() {
		InputDisplay.askInputFunctionSelectionNumber();
		String functionSelectionNumber = InputController.inputFunctionSelectionNumber();

		if (functionSelectionNumber.equals("1")) {
			OutputDisplay.showProcessAndLevelAndMission();
		}
	}
}
