package pairmatching.controller;

import java.util.List;
import pairmatching.utils.FunctionFactory;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

	private MatchingController() {
	}

	public static void controlMatching() {
		List<String> functions = FunctionFactory.makeFunctions();
		InputView.selectFunction(functions);
	}
}
