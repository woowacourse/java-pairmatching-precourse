package pairmatching.exception;

public class EmptyException {

	static final String EMPTY_EXCEPTION = "값이 입력되지 않았습니다.";

	public static String checkEmptyInput(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException(EMPTY_EXCEPTION);
		}
		return input;
	}
}
