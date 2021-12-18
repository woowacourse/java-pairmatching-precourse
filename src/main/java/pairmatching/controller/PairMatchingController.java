package pairmatching.controller;

import pairmatching.exception.dto.ResponseError;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;

public class PairMatchingController {

	private PairMatchingService pairMatchingService;

	public PairMatchingController() {
		this.pairMatchingService = new PairMatchingService();
	}

	public void selectFunction() {
		try {
			InputView.PrintSelectFunction();
			pairMatchingService.selectFunction();
			InputView.printProcessMissionLevel();
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}
	}

	public void selectProcessLevelMission() {
		try {
			InputView.printSelectProcessMissionLevel();
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}
	}

}
