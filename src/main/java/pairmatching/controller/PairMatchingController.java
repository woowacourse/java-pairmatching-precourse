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

	public void run() {
		TechCourse techCourse = new TechCourse();

		while (true) {
			String mainCommend = getMainCommend();
			if (mainCommend.equals(MATCH_PAIR)) {
				matchPair();
			}
			if (mainCommend.equals(LOOKUP_PAIR)) {
				lookUpPair();
			}
			if (mainCommend.equals(RESET_PAIR)) {
				resetPair();
			}
			if (mainCommend.equals(TERMINATION)) {
				return;
			}
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
