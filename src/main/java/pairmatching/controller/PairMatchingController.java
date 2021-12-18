package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	OutputView outputView = new OutputView();
	InputView inputView = new InputView();

	public void start() {
		String userInput;
		while (true) {
			outputView.printFunction();
			userInput = inputView.getFunction();
			if (userInput.equals("Q")) {
				return;
			}
			selectFunction(userInput);
		}
	}

	public void selectFunction(String functionNumber) {
		if (functionNumber.equals("1")) {
			return;
		}
		if (functionNumber.equals("2")) {
			return;
		}
		if (functionNumber.equals("3")) {
			return;
		}
	}

}
