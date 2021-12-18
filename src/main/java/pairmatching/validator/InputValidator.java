package pairmatching.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
	private static final int PAIR_MATCHING_INPUT_SIZE = 3;

	private static final String IS_SIZE_THREE_ERROR_MESSAGE = "입력 형식을 맞춰야 합니다.";
	private static final String CONTAIN_FUNCTION_CHOICE_LIST_ERROR_MESSAGE = "기능 선택 번호를 입력해주세요.";

	private static final List<String> FUNCTION_CHOICE_LIST = Arrays.asList(
		"1", "2", "3", "Q"
	);

	public static void isSizeThree(String[] stringArray) throws IllegalArgumentException {
		if (stringArray.length != PAIR_MATCHING_INPUT_SIZE) {
			throw new IllegalArgumentException(IS_SIZE_THREE_ERROR_MESSAGE);
		}
	}

	public static void containFunctionChoiceList(String input) throws IllegalArgumentException {
		if (!FUNCTION_CHOICE_LIST.contains(input)) {
			throw new IllegalArgumentException(CONTAIN_FUNCTION_CHOICE_LIST_ERROR_MESSAGE);
		}
	}
}
