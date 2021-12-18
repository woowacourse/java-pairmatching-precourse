package pairmatching.util;

public class InputValidator {
	private static final String MATCH_PAIR = "1";
	private static final String LOOKUP_PAIR = "2";
	private static final String RESET_PAIR = "3";
	private static final String TERMINATION = "Q";
	private static final String ERROR = "[ERROR] ";
	private static final String INPUT_ERROR = "유효하지 않은 입력입니다.";

	public static void mainCommend(String mainCommend) {
		if (!(mainCommend.equals(MATCH_PAIR) || mainCommend.equals(LOOKUP_PAIR) || mainCommend.equals(RESET_PAIR) || mainCommend.equals(TERMINATION))) {
			throw new IllegalArgumentException(ERROR + INPUT_ERROR);
		}
	}
}
