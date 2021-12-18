package pairmatching;

import java.util.Set;

public class InputValidator {
	private static final String FUNCTION_INPUT_ERROR_TEXT = "[ERROR] 제공된 기능 중 하나를 선택 하세요";

	public static void validateAllowedFunction(String input) {
		if (!Function.isContainsKey(input)) {
			throw new IllegalArgumentException(FUNCTION_INPUT_ERROR_TEXT);
		}
	}
}
