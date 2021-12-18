package pairmatching.util;

import pairmatching.view.ErrorMessage;

public class FunctionValidator {

	public static final String FUNCTION_FORM = "[123Q]";

	public static void validateInputForm(String inputString) {
		if (!inputString.matches(FUNCTION_FORM)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_FUNCTION_FORM);
		}
	}
}
