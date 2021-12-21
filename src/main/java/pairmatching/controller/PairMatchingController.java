package pairmatching.controller;

import static pairmatching.constant.ErrorMessage.*;

import pairmatching.domain.Curriculum;
import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private static final String PAIR_MATCH_NUMBER = "1";
	private static final String PAIR_SEARCH_NUMBER = "2";
	private static final String PAIR_CLEAR_NUMBER = "3";
	private static final String APP_QUIT_CHAR = "Q";

	private String input;
	private PairMatching pairMatching = new PairMatching();

	public void run() {
		do {
			OutputView.printGuide();
			input = InputView.readString();
			orderByInput();
		} while (!quit());
	}

	private void orderByInput() {
		if (input.equals(PAIR_MATCH_NUMBER)) {
			matchPair();
			return;
		}
		if (input.equals(PAIR_SEARCH_NUMBER)) {
			searchPair();
			return;
		}
		if (input.equals(PAIR_CLEAR_NUMBER)) {
			clearPair();
			return;
		}
		throw new IllegalArgumentException(WRONG_INPUT);
	}

	private void matchPair() {
		OutputView.printEnterCurriculum();
		Curriculum curriculum = InputView.readCurriculum();
		if (isPair(curriculum)) {
			// 존재하면 만들지 말지 물어봐야함
			return;
		}
	}

	private boolean isPair(Curriculum curriculum) {
		return !pairMatching.isEmpty(curriculum);
	}

	private boolean askRematch() {
		String input = InputView.readString();
		if (input.equals("네")) {
			return true;
		}
		if (input.equals("아니오")) {
			return false;
		}
		throw new IllegalArgumentException(WRONG_INPUT);
	}

	private void searchPair() {
		OutputView.printCourse();
		Curriculum curriculum = InputView.readCurriculum();
		System.out.println();
		// 구현남음
	}

	private void clearPair() {
		pairMatching.clearMatching();
	}

	private boolean quit() {
		return input.equals(APP_QUIT_CHAR);
	}
}
