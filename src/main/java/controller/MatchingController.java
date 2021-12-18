package controller;

import model.PairMatcher;
import view.InputDisplay;
import view.OutputDisplay;

public class MatchingController {

	private MatchingController() {
	}

	public static void runMatchingProgram() {
		PairMatcher pairMatcher = new PairMatcher();
		InputDisplay.askInputFunctionSelectionNumber();
		String functionSelectionNumber = InputController.inputFunctionSelectionNumber();

		if (functionSelectionNumber.equals("1")) {
			OutputDisplay.showProcessAndLevelAndMission();
			InputDisplay.askInputProcessAndLevelAndMission();
			InputController.inputProcessAndLevelAndMission();
		}
	}
}
