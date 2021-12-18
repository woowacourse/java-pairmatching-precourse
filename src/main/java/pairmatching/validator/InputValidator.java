package pairmatching.validator;

public class InputValidator {
	private static final String IS_SIZE_THREE_ERROR_MESSAGE = "입력 형식을 맞춰야 합니다.";

	public static void isSizeThree(String[] stringArray) throws IllegalArgumentException {
		if (stringArray.length != 3) {
			throw new IllegalArgumentException(IS_SIZE_THREE_ERROR_MESSAGE);
		}
	}
}
