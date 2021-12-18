package pairmatching.util;

public class RetryValidator extends Validator {
	private static final String YES = "네";
	private static final String NO = "아니오";

	public static void isRightRetry(String input) {
		isEmpty(input);
		if (!input.equals(YES) && !input.equals(NO)) {
			throw new IllegalArgumentException("네 혹은 아니오 로만 대답해주세요.");
		}
	}
}
