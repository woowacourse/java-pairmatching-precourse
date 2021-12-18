package controller;

import model.PairMatcher;
import view.InputDisplay;
import view.OutputDisplay;

public class MatchingController {

	private MatchingController() {
	}

	public static void runMatchingProgram() {
		PairMatcher pairMatcher = new PairMatcher();
		while (true) {
			InputDisplay.askInputFunctionSelectionNumber();

			String functionSelectionNumber = InputController.inputFunctionSelectionNumber();

			if (functionSelectionNumber.equals("1")) {
				operateMatchingFunction(pairMatcher);
			}
			if (functionSelectionNumber.equals("Q")) {
				break;
			}
		}
	}

	private static void operateMatchingFunction(PairMatcher pairMatcher) {
		OutputDisplay.showProcessAndLevelAndMission();
		while(true) {
			try {
				InputDisplay.askInputProcessAndLevelAndMission();
				OutputDisplay.showMatchedPairs(
					pairMatcher.matchingPairs(InputController.inputProcessAndLevelAndMission()));
				break;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
