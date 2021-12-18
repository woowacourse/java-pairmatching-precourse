package pairmatching.validator;

import pairmatching.domain.Function;

public class FunctionValidator {

	private static final String FUNCTION_SELECT_ERROR = "[ERROR] 1, 2, 3, Q 중에서 선택해야 합니다.\n";

	public void validateFunctionNumber(String input) {
		if (!Function.isValidNumber(input)) {
			throw new IllegalArgumentException(FUNCTION_SELECT_ERROR);
		}
	}
}
