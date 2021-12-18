package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	String function;
	InputView inputView;
	OutputView outputView;

	public PairMatchingController() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void run() {
		try {
			do {
				function = inputView.requestFunction();
			} while (function.equals("Q"));
		}catch (Exception exception){
			outputView.reportException(exception.getMessage());
		}
	}
}
