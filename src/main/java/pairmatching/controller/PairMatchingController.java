package pairmatching.controller;

import static pairmatching.exception.EmptyException.*;
import static pairmatching.exception.FunctionException.*;

import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	String function;
	InputView inputView;
	OutputView outputView;
	PairService pairService;

	public PairMatchingController() {
		function = "";
		inputView = new InputView();
		outputView = new OutputView();
		pairService = new PairService();
	}

	public void run() {
		do {
			try {
				function = checkCorrectFunction(checkEmptyInput(inputView.requestFunction()));
				proceedFunction(function);
			} catch (Exception exception) {
				outputView.reportException(exception.getMessage());
			}
		} while (!function.equals("Q"));
	}

	private void proceedFunction(String function) {
		if (function.equals("1")) {
			pairService.match(checkEmptyInput(inputView.requestSource()));
		}
		if (function.equals("2")) {
			pairService.look(checkEmptyInput(inputView.requestSource()));
		}
		if (function.equals("3")) {
			pairService.init();
		}
	}
}
