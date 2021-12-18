package pairmatching.controller;

import pairmatching.domain.CrewMaker;
import pairmatching.function.PairFunction;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void run() {
		CrewMaker.run();
		while (true) {
			try {
				String menu = getFunctionMenuInput();
				PairFunction pairFunction = PairFunction.getPairFunctionByMenu(menu);
				if (pairFunction == PairFunction.QUIT) {
					break;
				}
				pairFunction.operate();
			} catch (IllegalArgumentException e) {
				OutputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private String getFunctionMenuInput() {
		return InputView.getFunctionMenuInput();
	}

}
