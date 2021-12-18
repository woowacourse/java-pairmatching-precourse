package pairmatching.controller;

import java.util.List;

import pairmatching.model.Matching;
import pairmatching.view.PairMatchingInputView;

public class PairMatchingController {
	private List<String> crewNames; // 역대 매칭된 페어정보만

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
	}
}
