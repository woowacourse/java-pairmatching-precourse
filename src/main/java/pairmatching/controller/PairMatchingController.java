package pairmatching.controller;

import pairmatching.model.enums.Mission;
import pairmatching.model.enums.Process;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final String PAIR_MATCHING = "1";

	public void selectMenu() {
		try {
			excuteMenu(InputView.getMenu());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			selectMenu();
		}
	}

	private void excuteMenu(String menu) {
		if (menu.equals(PAIR_MATCHING)) {
			matchPair();
		}
	}

	private void matchPair() {
		OutputView.printProcessAndMission(Process.getProcessMessage(), Mission.getMissionMessage());
	}
}
