package pairmatching.validator;

public class OrderValidator {

	private static final String MATCHING = "1";
	private static final String SEARCH = "2";
	private static final String INIT = "3";
	private static final String KILL = "Q";

	public static void checkOrder(String input) {
		if (input.equals(MATCHING)) {
			return;
		}
		if (input.equals(SEARCH)) {
			return;
		}
		if (input.equals(INIT)) {
			return;
		}
		if (input.equals(KILL)) {
			return;
		}

		throw new IllegalArgumentException("잘못된 입력입니다.");
	}

}
