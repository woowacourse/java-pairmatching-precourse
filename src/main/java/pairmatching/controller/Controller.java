package pairmatching.controller;

import pairmatching.domain.PairMachine;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
	public void runPairMatching() {
		//메인로직
		PairMachine pairMachine = PairMachine.getInstance();
		pairMachine.init();

		OutputView.printInputFunctionMenuInstruction();
		InputView.getFunctionMenu();
	}
}
