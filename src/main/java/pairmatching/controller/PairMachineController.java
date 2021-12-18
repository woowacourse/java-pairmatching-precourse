package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.domain.PairMachineFunction;

public class PairMachineController {
	public void run() {
		printMainScreen();
		PairMachineFunction pairMachineFunction = PairMachineFunction.findFunction(inputPairFunction());
		pairMachineFunction.apply();
	}
}
