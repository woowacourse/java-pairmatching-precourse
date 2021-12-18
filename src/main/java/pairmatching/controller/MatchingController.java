package pairmatching.controller;

import java.util.List;
import pairmatching.model.Pair;
import pairmatching.utils.BasicInformationFactory;
import pairmatching.utils.FunctionFactory;
import pairmatching.utils.PairFactory;
import pairmatching.view.InputView;

public class MatchingController {

	private static final String QUIT_NUMBER = "Q";
	private static final String PAIR_MATCHING_NUMBER = "1";

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
				List<Pair> pairs = PairFactory.makePairs();
			}
		}
	}

	public static List<String> controlInformationSelect() {
		BasicInformationFactory.noticeBasicInformation();
		return InputView.selectInformation();
	}

	private static boolean isTerminateCondition(String functionNumber) {
		return functionNumber.equals(QUIT_NUMBER);
	}
}
