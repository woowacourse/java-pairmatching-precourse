package pairmatching.utils;

public class Validator {
	private static final String INVALID_FUNCTION = "[ERROR] 잘못된 기능 입력입니다.";
	private static final int MAX_FUNCTION_NUMBER = 3;

	public static void validateFunctionNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			if (number > MAX_FUNCTION_NUMBER) {
				throw new IllegalArgumentException(INVALID_FUNCTION);
			}
		} catch (NumberFormatException e) {
			if (input.equals("Q")) {
				return;
			}
			throw new IllegalArgumentException(INVALID_FUNCTION);
		}
	}
}
