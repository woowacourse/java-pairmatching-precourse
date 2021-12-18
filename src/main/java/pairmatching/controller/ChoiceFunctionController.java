package pairmatching.controller;

import pairmatching.validator.InputValidator;
import pairmatching.view.ExceptionView;
import pairmatching.view.InputView;

public class ChoiceFunctionController {
	public static String choiceFunction() {
		try {
			String input = InputView.choiceFunction();
			InputValidator.containFunctionChoiceList(input);
			return input;
		} catch (IllegalArgumentException e) {
			ExceptionView.exceptionUI(e.getMessage());
			return choiceFunction();
		}
	}
}
