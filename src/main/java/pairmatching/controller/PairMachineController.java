package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.controller.function.PairMatchingFunction;

public class PairMachineController {
	public void run() {
		try{
			printMainScreen();
			PairMatchingFunction pairMatchingFunction = PairMatchingFunction.findFunction(inputPairFunction());
			pairMatchingFunction.apply();
			if (pairMatchingFunction.isQuit()) {
				return;
			}
			run();
		}catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			run();
		}
	}
}
