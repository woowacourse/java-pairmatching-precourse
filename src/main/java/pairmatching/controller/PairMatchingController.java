package pairmatching.controller;

import java.util.List;

import pairmatching.model.Matching;
import pairmatching.view.PairMatchingInputView;
import pairmatching.view.PairMatchingOutputView;

public class PairMatchingController {
	private List<Matching> matches;

	public PairMatchingController() {
	}

	public void run() {
		while (true) {
			String inputFunction = PairMatchingInputView.readFunction();
			if (inputFunction.equals("1")) {
				match();
			}
			if (inputFunction.equals("Q")) {
				break;
			}
		}
	}

	private void match() {
		String inputMatchingCondition = PairMatchingInputView.readCourseAndMission();
		Matching matching = new Matching(inputMatchingCondition);
		matches.add(matching);
		PairMatchingOutputView.printMatchingResult(matching.toString());
	}
}
