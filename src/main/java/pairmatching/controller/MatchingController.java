package pairmatching.controller;

import java.util.List;
import pairmatching.model.Information;
import pairmatching.model.Pairs;
import pairmatching.utils.BasicInformationFactory;
import pairmatching.utils.FunctionFactory;
import pairmatching.utils.PairFactory;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

	private static final String QUIT_NUMBER = "Q";
	private static final String PAIR_MATCHING_NUMBER = "1";
	private static final String PAIR_SEARCH_NUMBER = "2";
	private static final String PAIR_RESET = "3";

	private MatchingController() {
	}

	public static void controlMatching() {
		controlFunctionSelect();
	}

	private static void controlFunctionSelect() {
		while (true) {
			String functionNumber = InputView.selectFunction(FunctionFactory.makeFunctions());
			if (isTerminateCondition(functionNumber)) {
				break;
			}
			if (functionNumber.equals(PAIR_MATCHING_NUMBER)) {
				Information information = MatchingController.controlInformationSelect();
				if (information.isPaired()) {
					checkRepair();
				}
				if (!information.isPaired()) {
					Pairs pairs = PairFactory.checkRePair(information);
				}
			}
			if (functionNumber.equals(PAIR_SEARCH_NUMBER)) {
				// 조회하기
				Information information = MatchingController.controlInformationSelect();
				OutputView.printPair(PairFactory.checkRePair(information));
			}
			if (functionNumber.equals(PAIR_RESET)) {
				// 초기화하기
			}
		}
	}

	private static void checkRepair() {
		if (InputView.askRePair().equals("아니오")) {
			controlInformationSelect();
		}
	}

	public static Information controlInformationSelect() {
		BasicInformationFactory.noticeBasicInformation();
		List<String> information = InputView.selectInformation();
		return new Information(information.get(0), information.get(1), information.get(2));
	}

	private static boolean isTerminateCondition(String functionNumber) {
		return functionNumber.equals(QUIT_NUMBER);
	}
}
