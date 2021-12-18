package pairmatching.controller;

import java.io.IOException;

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
			if(!pairMatchingService.selectProcessLevelMission(Console.readLine())) {
				selectProcessLevelMission();
			}
		} catch (IllegalArgumentException | IOException e) {
			ResponseError.of(e.getMessage());
		}
	}
}
