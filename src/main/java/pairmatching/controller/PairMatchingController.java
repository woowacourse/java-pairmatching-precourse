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
	}

	private void matchPair() {
		try {
			OutputView.printProcessAndMission(Process.getProcessMessage(), Mission.getMissionMessage());
			String matchingInput = InputView.getMatchingInput();
			MatchingService matchingService = new MatchingService();
			Matching newMatching = matchingService.getMatching(matchingInput);
			newMatching = selectOriginOrNew(newMatching);
			String newMatchingCombination = getMatchingCombination(newMatching);
			OutputView.printCombination(newMatchingCombination);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			matchPair();
		}
	}

	private Matching selectOriginOrNew(Matching newMatching) {
		if (matchingHistory.has(newMatching)) {
			newMatching = getOriginalOrNewMatching(newMatching);
			return newMatching;
		}
		return newMatching;
	}

	private Matching getOriginalOrNewMatching(Matching newMatching) {
		String originOrRematchNumber = InputView.getOriginOrRematchNumber();
		if (originOrRematchNumber.equals(ORIGIN)) {
			newMatching = matchingHistory.getSameMatch(newMatching);
		}
		return newMatching;
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
}
