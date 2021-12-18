package pairmatching.controller;

import pairmatching.service.CrewService;
import pairmatching.service.PairMatchingService;
import pairmatching.view.ExceptionView;
import pairmatching.view.InputView;

public class PairMatchingController {
	private final CrewService crewService = new CrewService();
	private final PairMatchingService pairMatchingService = new PairMatchingService();



	public PairMatchingController() {
	}

	public void pairMatching() {
		try {
			String input = InputView.requestCourseLevelMission();
			pairMatchingService.pairMathcing(input);
		} catch (IllegalArgumentException e) {
			ExceptionView.exceptionUI(e.getMessage());
			pairMatching();
		}
	}
}
