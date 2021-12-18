package pairmatching.controller;

import java.util.StringTokenizer;

import pairmatching.Service.PairService;
import pairmatching.domain.Course;
import pairmatching.domain.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
	public static final String PAIR_MATCHING = "1";
	public static final String PAIR_SEARCHING = "2";
	public static final String PAIR_RESET = "3";
	public static final String EXIT = "Q";
	public static final int INIT_COUNT = 0;

	public void run() {
		String function = InputView.requestFunction();
		if (function.equals(PAIR_MATCHING)) {
			makePair();
		}
		if (function.equals(PAIR_SEARCHING)) {
			searchPair();
		}
		if (function.equals(PAIR_RESET)) {
			resetPair();
		}
		if (function.equals(EXIT)) {
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
			makeBackRandomPairAndPrint(mission, INIT_COUNT);
		}

		if (course.equals(Course.FRONTEND.getName())) {
			makeFrontRandomPairAndPrint(mission, INIT_COUNT);
		}
		run();
	}

	private void makeBackRandomPairAndPrint(String mission, int count) {
		Pairs pairs = PairService.makeBackPairs(mission);
		if (pairs.equals(null) && count < 3) {
			if (InputView.requestTry()) {
				makeBackRandomPairAndPrint(mission, count++);
			}
		}
		OutputView.printPairs(pairs, count);
	}

	private void makeFrontRandomPairAndPrint(String mission, int count) {
		Pairs pairs = PairService.makeFrontPairs(mission);
		if (pairs.equals(null) && count < 3) {
			if (InputView.requestTry()) {
				makeFrontRandomPairAndPrint(mission, count++);
			}
		}
		OutputView.printPairs(pairs, count);
	}

	private void searchPair() {
		String inputMissionInfo = InputView.requestMission();
		StringTokenizer stringTokenizer = new StringTokenizer(inputMissionInfo, ",");

		String course = stringTokenizer.nextToken();
		String level = stringTokenizer.nextToken();
		String mission = stringTokenizer.nextToken();

		if (course.equals(Course.BACKEND.getName())) {
			Pairs backPairs = PairService.getBackPairs(mission);
			System.out.println(OutputView.getPrintPairs(backPairs));
		}
		if (course.equals(Course.FRONTEND.getName())) {
			Pairs frontPairs = PairService.getFrontPairs(mission);
			System.out.println(OutputView.getPrintPairs(frontPairs));
		}
		run();
	}
}
