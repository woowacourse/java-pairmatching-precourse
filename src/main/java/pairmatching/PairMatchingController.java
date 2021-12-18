package pairmatching;

import pairmatching.domain.Function;

public class PairMatchingController {

	public void run() {
		Function selectedFunction = requestFunctionSelect();
		run(selectedFunction);
	}

	private Function requestFunctionSelect() {
		return Input.requestFunctionSelect();
	}

	private void run(Function function) {
		if (function == Function.QUIT) {
			return;
		}
	}
}
