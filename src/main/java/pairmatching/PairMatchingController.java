package pairmatching;

import pairmatching.domain.Function;

public class PairMatchingController {

	public void run() {
		Function selectedFunction = requestFunctionSelect();
		run(selectedFunction);
	}

	private Function requestFunctionSelect() {
		return Input.requestToSelectFunction();
	}

	private void run(Function function) {
		if (function == Function.QUIT) {
			return;
		}
		if (function == Function.RESET) {
			return;
		}

		Input.requestToSelectMission();
	}
}
