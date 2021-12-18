package pairmatching.controller;

import pairmatching.domain.PairMatcher;
import pairmatching.view.InputView;

public class PairMathcerController {
	private PairMatcher pairMatcher;

	public void init() {
		String inputFunctionNumber = InputView.getFunctionNumber();
		pairMatcher.run(inputFunctionNumber);

	}
}
