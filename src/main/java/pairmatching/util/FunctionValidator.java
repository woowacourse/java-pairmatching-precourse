package pairmatching.util;

public class FunctionValidator {

	public static final String FUNCTION_FORM = "[123Q]";
	public static final String INVALID_FUNCTION_FORM = "1, 2, 3, Q 중에 하나를 입력해주세요.";

	public static void validateInputForm(String inputString) {
		if (!inputString.matches(FUNCTION_FORM)) {
			throw new IllegalArgumentException(INVALID_FUNCTION_FORM);
		}
	}
}
