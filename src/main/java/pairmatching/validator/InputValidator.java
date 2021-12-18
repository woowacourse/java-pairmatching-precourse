package pairmatching.validator;

import pairmatching.exception.InputException;

public class InputValidator {

	public static void checkInputValidation(String input) {
		if ("1".equals(input) || "2".equals(input) || "3".equals(input) || "Q".equals(input)) {
			return;
		}
		InputException.printInvalidInputError();
	}

}
