package pairmatching.controller;

import static pairmatching.exception.EmptyException.*;

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
				function = checkEmptyInput(inputView.requestFunction());
			} while (function.equals("Q"));
		}catch (Exception exception){
			outputView.reportException(exception.getMessage());
		}
	}
}
