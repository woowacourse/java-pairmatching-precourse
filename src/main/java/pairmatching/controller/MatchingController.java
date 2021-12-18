package pairmatching.controller;

import pairmatching.utils.BasicInformationFactory;
import pairmatching.utils.FunctionFactory;
import pairmatching.view.InputView;

public class MatchingController {

	private static final String QUIT_NUMBER = "Q";

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
			controlInformationSelect();
		}
	}

	private static void controlInformationSelect() {
		BasicInformationFactory.noticeBasicInformation();
		InputView.selectInformation();
	}

	private static boolean isTerminateCondition(String functionNumber) {
		return functionNumber.equals(QUIT_NUMBER);
	}
}
