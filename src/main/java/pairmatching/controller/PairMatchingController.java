package pairmatching.controller;

import java.io.FileNotFoundException;

import pairmatching.domain.PairCrews;
import pairmatching.service.CrewService;
import pairmatching.service.PairMatchingService;
import pairmatching.view.ExceptionView;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private final CrewService crewService = new CrewService();
	private final PairMatchingService pairMatchingService = new PairMatchingService();



	public PairMatchingController() {
		try {
			crewService.init();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void pairMatching() {
		try {
			String input = InputView.requestCourseLevelMission();
			PairCrews pairCrews = pairMatchingService.pairMatching(input);
			OutputView.printResultPairMatching(pairCrews);
		} catch (IllegalArgumentException e) {
			ExceptionView.exceptionUI(e.getMessage());
			pairMatching();
		}
	}
}
