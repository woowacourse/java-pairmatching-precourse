package pairmatching.controller;

import java.util.List;

import pairmatching.model.Matching;
import pairmatching.view.PairMatchingInputView;

public class PairMatchingController {
	private List<String> crewNames; // 역대 매칭된 페어정보만
	public PairMatchingController() {
	}

	public void run() {
		while (!PairMatchingInputView.readFunction().equals("Q")) {
			// 페어 매칭
			String inputMatchingCondition = PairMatchingInputView.readCourseAndMission();
			Matching pair = new Matching(inputMatchingCondition);
		}
	}
}
