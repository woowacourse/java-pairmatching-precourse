package pairmatching.controller;

import pairmatching.domain.TechCourse;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final String MATCH_PAIR = "1";
	private static final String LOOKUP_PAIR = "2";
	private static final String RESET_PAIR = "3";
	private static final String TERMINATION = "Q";
	private static final String NO = "아니오";

	public void run() {
		TechCourse techCourse = new TechCourse();

		while (true) {
			String mainCommend = getMainCommend();
			if (mainCommend.equals(MATCH_PAIR)) {
				OutputView.printMission();
				getPairList(techCourse);
			}
			if (mainCommend.equals(LOOKUP_PAIR)) {
				OutputView.printMission();
				String mission = matchPair();
				OutputView.showCrewList(techCourse.getCrewList(mission));
			}
			if (mainCommend.equals(RESET_PAIR)) {
				// resetPair();
			}
			if (mainCommend.equals(TERMINATION)) {
				return;
			}
		}
	}

	private void getPairList(TechCourse techCourse) {
		String mission = matchPair();
		seeIfShuffled(techCourse, mission);
		OutputView.showCrewList(techCourse.matchPair(mission));
	}

	private void seeIfShuffled(TechCourse techCourse, String mission) {
		if (techCourse.isShuffled(mission)) {
			String rematchCommend = getRematch();
			if (rematchCommend.equals(NO)) {
				getPairList(techCourse);
			}
		}
	}

	private String matchPair() {
		String mission = InputView.inputMission();
		try {
			return mission;
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			return matchPair();
		}
	}

	private String getRematch() {
		String rematch = InputView.inputRematch();
		try {
			InputValidator.rematch(rematch);
			return rematch;
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			return getRematch();
		}
	}

	private String getMainCommend() {
		String mainCommend = InputView.inputMainCommend();
		try {
			InputValidator.mainCommend(mainCommend);
			return mainCommend;
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			return getMainCommend();
		}
	}
}
