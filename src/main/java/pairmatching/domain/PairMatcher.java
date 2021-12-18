package pairmatching.domain;

import pairmatching.domain.input.FunctionType;

public class PairMatcher {

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

	private void resetPairs() {}

	private void exit() {}
}
