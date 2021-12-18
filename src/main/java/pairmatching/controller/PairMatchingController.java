package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Matching;
import pairmatching.utils.ErrorMessageConstants;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingOutputView;

public class PairMatchingController {
	private List<Matching> matches;

	public PairMatchingController() {
		matches = new ArrayList<>();
	}

	public void run() {
		while (true) {
			String inputFunction = PairMatchingInputView.readFunction();
			if (inputFunction.equals("1")) {
				match();
			}
			if (inputFunction.equals("2")) {
				search();
			}
			if (inputFunction.equals("3")) {
				matches.clear();
			}
			if (inputFunction.equals("Q")) {
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
			int trial = 0;
			while (trial < 3) {
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
