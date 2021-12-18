package pairmatching.controller;

import java.util.StringTokenizer;

import pairmatching.Service.PairService;
import pairmatching.domain.Course;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

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
		OutputView.printResetPairs();
		run();
	}

	private void makePair() {
		String inputMissionInfo = InputView.requestMission();
		StringTokenizer stringTokenizer = new StringTokenizer(inputMissionInfo, ",");

		String course = stringTokenizer.nextToken();
		String level = stringTokenizer.nextToken();
		String mission = stringTokenizer.nextToken();

		System.out.println(course + level + mission);

		if (course.equals(Course.BACKEND.getName())) {
			PairService.makeBackPairs(course, mission);
		}
		if (course.equals(Course.FRONTEND.getName())) {
			PairService.makeFrontPairs(course, mission);
		}
		run();
	}

	private void searchPair() {
		String inputMissionInfo = InputView.requestMission();
	}
}
