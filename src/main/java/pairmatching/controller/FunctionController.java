package pairmatching.controller;

import pairmatching.domain.Matching;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class FunctionController {

	MatchingService matchingService = new MatchingService();

	public void choiceFunction(String functionNumber) {
		if ("1".equals(functionNumber)) {
			pairMatching();
		}
		if ("2".equals(functionNumber)) {
			getPairMatching();
		}
		if ("3".equals(functionNumber)) {
			clearPair();
		}
	}

	private void pairMatching() {
		OutputView.printAdvanceInformation();
		String inputCourseAndLevelAndMission = InputView.inputCourseAndLevelAndMission();
		Matching matching = matchingService.generateRandomMatching(inputCourseAndLevelAndMission);
		OutputView.printMatchingInfo(matching);
	}

	private void getPairMatching() {
		matchingService.getMatchingList();
	}

	private void clearPair() {
		matchingService.clearMatchingList();
		OutputView.printClearMessage();
	}
}
