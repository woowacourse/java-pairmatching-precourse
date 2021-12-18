package pairmatching.controller;

import java.util.List;

import pairmatching.service.MissionService;
import pairmatching.util.InformationValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MenuController {
	private static final String PAIR_MATCHING = "1";
	private static final String FIND_PAIR = "2";
	private static final String INITIALIZE_PAIR = "3";
	private static final String EXIT = "Q";

	public void run(String menu, MissionService missionService) {
		if (menu.equals(PAIR_MATCHING)) {
			OutputView.printStatus(missionService);
			inputInformation(missionService.getMissionNames());
			return;
		}
		if (menu.equals(FIND_PAIR)) {
			OutputView.printStatus(missionService);
			return;
		}
		if (menu.equals(INITIALIZE_PAIR)) {
			OutputView.printInitializeMessage();
		}
	}

	private void inputInformation(List<String> missionNames) {
		try {
			String input = InputView.inputInformation();
			InformationValidator.isRightInformation(input, missionNames);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			inputInformation(missionNames);
		}
	}
}
