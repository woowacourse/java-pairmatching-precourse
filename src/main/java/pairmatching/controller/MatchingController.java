package pairmatching.controller;

import java.util.List;
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
		String functionNumber;
		do {
			functionNumber = InputView.selectFunction(FunctionFactory.makeFunctions());
		} while (!isTerminateCondition(functionNumber));
	}

	private static boolean isTerminateCondition(String functionNumber) {
		return functionNumber.equals(QUIT_NUMBER);
	}
}
