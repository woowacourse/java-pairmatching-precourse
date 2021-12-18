package pairmatching.controller;

import java.util.StringTokenizer;

import pairmatching.Service.PairService;
import pairmatching.domain.Course;
import pairmatching.domain.Pairs;
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

		if (course.equals(Course.BACKEND.getName())) {
			Pairs pairs = makeBackRandomPair(mission, 0);
			System.out.println(pairs);
		}

		if (course.equals(Course.FRONTEND.getName())) {
			Pairs pairs = makeFrontRandomPair(mission, 0);
			System.out.println(pairs);
		}
		run();
	}

	private Pairs makeBackRandomPair(String mission, int count) {
		Pairs pairs = PairService.makeBackPairs(mission);
		if (pairs.equals(null) && count < 3) {
			makeBackRandomPair(mission, count++);
		}
		return pairs;
	}

	private Pairs makeFrontRandomPair(String mission, int count) {
		Pairs pairs = PairService.makeFrontPairs(mission);
		if (pairs.equals(null) && count < 3) {
			makeFrontRandomPair(mission, count++);
		}
		return pairs;
	}

	private void searchPair() {
		String inputMissionInfo = InputView.requestMission();
		StringTokenizer stringTokenizer = new StringTokenizer(inputMissionInfo, ",");

		String course = stringTokenizer.nextToken();
		String level = stringTokenizer.nextToken();
		String mission = stringTokenizer.nextToken();

		if (course.equals(Course.BACKEND.getName())) {
			PairService.getBackPairs(mission);
		}
		if (course.equals(Course.FRONTEND.getName())) {
			PairService.getFrontPairs(mission);
		}
		run();
	}
}
