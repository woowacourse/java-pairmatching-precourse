package pairmatching;

import static pairmatching.Constant.*;

import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputValidator {
	private static final String FUNCTION_INPUT_ERROR_TEXT = "[ERROR] 제공된 기능 중 하나를 선택 하세요";
	private static final String METHOD_INPUT_FORM_ERROR_TEXT = "[ERROR] 과정, 레벨, 미션을 입력하세요";
	private static final String METHOD_INPUT_NOT_ALLOWED_OPTION = "[ERROR] 우테코에서 제공하고 있지 않은 옵션입니다";
	private static final String YES_OR_NO_ERROR_TEXT = "[ERROR] 예 혹은 아니오를 입력하세요";

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

	public static void validateAllowedOption(String[] elements) {
		if (!Course.isContains(elements[0])
		|| !Level.isContains(elements[1])
		|| !Mission.isContains(elements[2])
		|| !Mission.byName(elements[2]).isInLevel(Level.byName(elements[1]))) {
			throw new IllegalArgumentException(METHOD_INPUT_NOT_ALLOWED_OPTION);
		}
	}

	public static void validateYesOrNo(String input) {
		if (!input.equals(YES) && !input.equals(NO)) {
			throw new IllegalArgumentException(YES_OR_NO_ERROR_TEXT);
		}
	}
}
