package pairmatching.controller;

import pairmatching.domain.CrewMaker;
import pairmatching.function.PairFunction;
import pairmatching.view.InputView;

public class PairMatchingController {

	public void run() {
		CrewMaker.run();
		String menu = getFunctionMenuInput();
		PairFunction pairFunction = PairFunction.getPairFunctionByMenu(menu);
		pairFunction.operate();
	}

	private String getFunctionMenuInput() {
		return InputView.getFunctionMenuInput();
	}

}
