package pairmatching.controller;

import pairmatching.domain.PairMatcher;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;

public class PairMathcerController {
	private PairMatcher pairMatcher;

	public void init() {
		pairMatcher = new PairMatcher();
		runPairMatcher();
	}

	private void runPairMatcher() {
		try {
			String inputFunctionNumber = InputView.getFunctionNumber();
			pairMatcher.run(inputFunctionNumber);
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMesasge(e.getMessage());
			runPairMatcher();
		}
	}
}
