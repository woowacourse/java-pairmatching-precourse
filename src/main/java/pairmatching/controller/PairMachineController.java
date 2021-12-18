package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.controller.function.PairMatchingFunction;

public class PairMachineController {
	public void run() {
		printMainScreen();
		PairMatchingFunction pairMatchingFunction = PairMatchingFunction.findFunction(inputPairFunction());
		pairMatchingFunction.apply();
		if (pairMatchingFunction.isQuit()) {
			return;
		}
		run();
	}
}
