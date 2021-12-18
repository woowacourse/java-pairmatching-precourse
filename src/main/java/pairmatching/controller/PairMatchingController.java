package pairmatching.controller;

import java.util.List;

import pairmatching.view.InputView;

public class PairMatchingController {
	public void run() {
		// 크루 이름 획득
		List<String> backCrewNames = InputView.getCrewNameByFile("backend-crew.md");
		List<String> frontCrewNames = InputView.getCrewNameByFile("frontend-crew.md");
	}
}
