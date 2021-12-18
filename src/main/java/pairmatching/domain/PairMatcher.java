package pairmatching.domain;

import pairmatching.domain.input.FunctionType;
import pairmatching.domain.matching.Matchings;

public class PairMatcher {
	private Matchings matchings;

	public PairMatcher() {
		this.matchings = Matchings.newInstance();
	}

	public void run(String inputFunctionNumber) {
		FunctionType functionType = FunctionType.fromFunctionNumber(inputFunctionNumber);

		if (functionType == FunctionType.MATCH) {
			matchPairs();
			return;
		}
		if (functionType == FunctionType.VIEW) {
			viewPairs();
			return;
		}
		if (functionType == FunctionType.RESET) {
			resetPairs();
			return;
		}
		if (functionType == FunctionType.EXIT) {
			exit();
		}
	}

	private void matchPairs() {}

	private void viewPairs() {}

	private void resetPairs() {
		matchings.reset();
	}

	private void exit() {
	}
}
