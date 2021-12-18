package pairmatching.controller;

import static pairmatching.exception.EmptyException.*;
import static pairmatching.exception.FunctionException.*;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	String function;
	InputView inputView;
	OutputView outputView;

	public PairMatchingController() {
		function = "";
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void run() {
		do {
			try {
				function = checkCorrectFunction(checkEmptyInput(inputView.requestFunction()));
			} catch (Exception exception) {
				outputView.reportException(exception.getMessage());
			}
		} while (!function.equals("Q"));
	}
}
