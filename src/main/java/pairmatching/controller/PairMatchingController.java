package pairmatching.controller;

import java.util.List;

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
				String missionName = missionName();
				List<String> pairList = techCourse.getPairList(missionName);
				OutputView.showCrewList(pairList);
			}
			if (mainCommend.equals(RESET_PAIR)) {
				techCourse.resetPair();
			}
			if (mainCommend.equals(TERMINATION)) {
				return;
			}
		}
	}

	private void getPairList(TechCourse techCourse) {
		String missionName = missionName();
		seeIfShuffled(techCourse, missionName);
		List<String> pairList = techCourse.matchPair(missionName);
		OutputView.showCrewList(pairList);
	}

	private void seeIfShuffled(TechCourse techCourse, String mission) {
		if (techCourse.isShuffled(mission)) {
			String rematchCommend = getRematch();
			if (rematchCommend.equals(NO)) {
				getPairList(techCourse);
			}
		}
	}

	private String missionName() {
		String missionName = InputView.inputMission();
		try {
			return missionName;
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			return missionName();
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
