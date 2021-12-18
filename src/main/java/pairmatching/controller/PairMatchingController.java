package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Matching;
import pairmatching.utils.ErrorMessageConstants;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingOutputView;

public class PairMatchingController {
	private static final int ZERO = 0;
	private static final int TRIAL_LIMIT = 3;
	private static final String ONE = "1";
	private static final String TWO = "2";
	private static final String THREE = "3";
	private static final String QUIT = "Q";

	private List<Matching> matches;

	public PairMatchingController() {
		matches = new ArrayList<>();
	}

	public void run() {
		while (true) {
			String inputFunction = PairMatchingInputView.readFunction();
			if (inputFunction.equals(ONE)) {
				match();
			}
			if (inputFunction.equals(TWO)) {
				search();
			}
			if (inputFunction.equals(THREE)) {
				matches.clear();
			}
			if (inputFunction.equals(QUIT)) {
				break;
			}
		}
	}

	private void search() {
		String inputMatchingCondition = PairMatchingInputView.readCourseAndMission();
		Matching searchMatching = new Matching(inputMatchingCondition);
		if (!isDuplicateMatch(searchMatching)) {
			PairMatchingOutputView.printMatchingResult(searchMatching.toString());
			return;
		}
		throw new IllegalArgumentException(ErrorMessageConstants.NO_SUCH_MATCHING_EXCEPTION);
	}


	private void match() {
		String inputMatchingCondition = PairMatchingInputView.readCourseAndMission();
		Matching matching = new Matching(inputMatchingCondition);
		try {
			int trial = ZERO;
			while (trial < TRIAL_LIMIT) {
				matching.matchPairs();
				if (!isDuplicateMatch(matching)) {
					break;
				}
				trial++;
			}
			matches.add(matching);
			PairMatchingOutputView.printMatchingResult(matching.toString());
		} catch (IllegalArgumentException exception) {
			PairMatchingOutputView.printErrorMessage(ErrorMessageConstants.PAIR_TRIAL_EXCEED_EXCEPTION);
		}
	}

	private boolean isDuplicateMatch(Matching searchMatching) {
		for (Matching matching : matches) {
			if (matching.equals(searchMatching)) {
				return true;
			}
		}
		return false;
	}
}
