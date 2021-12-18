package pairmatching.controller;

import pairmatching.domain.CrewMaker;
import pairmatching.function.PairFunction;
import pairmatching.view.InputView;

public class PairMatchingController {

	public void run() {
		while (true) {
			CrewMaker.run();
			String menu = getFunctionMenuInput();
			PairFunction pairFunction = PairFunction.getPairFunctionByMenu(menu);
			if (pairFunction == PairFunction.QUIT) {
				break;
			}
			pairFunction.operate();
		}
	}

	private String getFunctionMenuInput() {
		return InputView.getFunctionMenuInput();
	}

}
