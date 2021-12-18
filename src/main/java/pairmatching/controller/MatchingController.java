package pairmatching.controller;

import pairmatching.utils.FunctionFactory;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

	private MatchingController() {
	}

	public static void controlMatching() {
		OutputView.askFunction(FunctionFactory.makeFunctions());
		InputView.selectFunction();
	}
}
