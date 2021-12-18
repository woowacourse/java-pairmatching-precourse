package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InputController {
	public String scanSelectFunction() {
		while (true) {
			try {
				InputView.askSelectFunction();
				String functionNum = Console.readLine();
				InputValidator.isValidFunctionNum(functionNum);
				return functionNum;
			} catch (IllegalArgumentException e) {
				OutputView.printInputFunctionError();
			}
		}
	}
}
