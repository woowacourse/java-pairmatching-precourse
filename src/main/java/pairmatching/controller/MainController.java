package pairmatching.controller;

import java.util.StringTokenizer;

import pairmatching.Service.PairService;
import pairmatching.domain.Course;
import pairmatching.view.InputView;

public class MainController {
	public void run() {
		String function = InputView.requestFunction();
		if (function.equals("1")) {
			makePair();
		}
		if (function.equals("2")) {
			searchPair();
		}
		if (function.equals("3")) {
			resetPair();
		}
		if (function.equals("4")) {

		}
	}

	private void resetPair() {
		PairService.resetPairs();
	}

	private void makePair() {
		String inputMissionInfo = InputView.requestMission();
		StringTokenizer stringTokenizer = new StringTokenizer(inputMissionInfo, ",");
		String course = stringTokenizer.nextToken();
		String level = stringTokenizer.nextToken();
		String mission = stringTokenizer.nextToken();
		if (course.equals(Course.BACKEND.getName())) {
			PairService.makeBackPairs(course,mission);
		}
		if (course.equals(Course.FRONTEND.getName())) {
			PairService.makeFrontPairs(course,mission);
		}
	}

	private void searchPair() {
		String inputMissionInfo = InputView.requestMission();
	}
}
