package pairmatching;

import static pairmatching.Constant.*;

import pairmatching.domain.Function;

public class InputValidator {
	private static final String FUNCTION_INPUT_ERROR_TEXT = "[ERROR] 제공된 기능 중 하나를 선택 하세요";
	private static final String METHOD_INPUT_FORM_ERROR_TEXT = "[ERROR] 과정, 레벨, 미션을 입력하세요";

	public static void validateAllowedFunction(String input) {
		if (!Function.isContainsKey(input)) {
			throw new IllegalArgumentException(FUNCTION_INPUT_ERROR_TEXT);
		}
	}

	public static void validateMissionInputContainsThreeElements(String input) {
		if (input.split(COMMA).length != 3) {
			throw new IllegalArgumentException(METHOD_INPUT_FORM_ERROR_TEXT);
		}
	}
}
