package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.dto.ResponseError;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;

public class PairMatchingController {

	private PairMatchingService pairMatchingService;

	public PairMatchingController() {
		this.pairMatchingService = new PairMatchingService();
	}

	public boolean selectFunction() {
		try {
			boolean start = true;
			InputView.PrintSelectFunction();
			return pairMatchingService.selectFunction(Console.readLine());


		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}

		return true;
	}

	public void selectProcessLevelMission() {
		try {
			InputView.printSelectProcessMissionLevel();
		} catch (IllegalArgumentException e) {
			ResponseError.of(e.getMessage());
		}
	}

}
