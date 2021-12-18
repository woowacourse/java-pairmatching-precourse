package pairmatching.utils.exception;

import java.util.List;

public class InputException {

	private static final String SPACE = " ";
	public static final String CONTAIN_SPACE = "공백이 입력되었습니다.";
	public static final String INVALID_NUMBER = "번호가 잘못 입력되었습니다.";

	private InputException() {
	}

	public static void validateFunctionNumber(String number, List<String> functions) {
		if (containSpace(number)) {
			throw new IllegalArgumentException(CONTAIN_SPACE);
		}
		for (String function : functions) {
			if (function.startsWith(number)) {
				return;
			}
		}
		throw new IllegalArgumentException(INVALID_NUMBER);
	}

	private static boolean containSpace(String input) {
		return input.isEmpty() || input.contains(SPACE);
	}
}
