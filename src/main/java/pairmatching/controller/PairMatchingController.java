package pairmatching.controller;

import pairmatching.model.Matching;
import pairmatching.model.MatchingHistory;
import pairmatching.model.enums.Mission;
import pairmatching.model.enums.Process;
import pairmatching.model.process.BackEnd;
import pairmatching.model.process.FrontEnd;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final String PAIR_MATCHING = "1";
	private static final String PAIR_CHECK = "2";
	private static final String RESET_PAIR = "3";
	private static final String ORIGIN = "아니오";
	private static final int COMBINATION_COUNT = 3;

	private BackEnd backEnd = new BackEnd();
	private FrontEnd frontEnd = new FrontEnd();
	private MatchingHistory matchingHistory = new MatchingHistory();

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
		if (menu.equals(PAIR_CHECK)) {
			checkPair();
		}
		if (menu.equals(RESET_PAIR)) {
			resetPair();
		}
	}

	private void matchPair() {
		try {
			OutputView.printProcessAndMission(Process.getProcessMessage(), Mission.getMissionMessage());
			String matchingInput = InputView.getMatchingInput();
			MatchingService matchingService = new MatchingService();
			Matching newMatching = matchingService.getMatching(matchingInput);
			String matchingMessage = selectOriginOrNew(newMatching);
			OutputView.printCombination(matchingMessage);
			selectMenu();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			matchPair();
		}
	}

	private String selectOriginOrNew(Matching newMatching) {
		if (matchingHistory.has(newMatching)) {
			return getOriginalOrNewMatching(newMatching);
		}
		String newMatchingCombination = getMatchingCombination(newMatching);
		return newMatchingCombination;
	}

	private String getOriginalOrNewMatching(Matching newMatching) {
		String originOrRematchNumber = InputView.getOriginOrRematchNumber();
		if (originOrRematchNumber.equals(ORIGIN)) {
			newMatching = matchingHistory.getSameMatch(newMatching);
			return newMatching.getCombinationMessage();
		}
		return getMatchingCombination(newMatching);
	}

	private String getMatchingCombination(Matching newMatching) {
		for (int count = 0; count < COMBINATION_COUNT; count++) {
			newMatching.makeCombination();
			if (!matchingHistory.hasSameCombination(newMatching)) {
				matchingHistory.add(newMatching);
				break;
			}
			newMatching.deleteCombination();
		}
		return newMatching.getCombinationMessage();
	}

	private void checkPair() {
		OutputView.printProcessAndMission(Process.getProcessMessage(), Mission.getMissionMessage());
		String matchingInput = InputView.getMatchingInput();
		MatchingService matchingService = new MatchingService();
		Matching searchMatching = matchingService.getMatching(matchingInput);
		printMatching(searchMatching);
	}

	private void printMatching(Matching searchMatching) {
		try {
			findMatching(searchMatching);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			checkPair();
		}
	}

	private void findMatching(Matching searchMatching) {
		if (!matchingHistory.has(searchMatching)) {
			throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
		}
		searchMatching = matchingHistory.getSameMatch(searchMatching);
		String searchMatchingCombination = getMatchingCombination(searchMatching);
		OutputView.printCombination(searchMatchingCombination);
		selectMenu();
	}

	private void resetPair() {
		matchingHistory.resetPair();
		OutputView.printResetPair();
		selectMenu();
	}
}
