package pairmatching.validator;

public class YesOrNoValidator {

	private static final String YES = "네";
	private static final String NO = "아니오";

	private static final String ANSWER_ERROR = "[ERROR] 네, 아니오로만 대답해야 합니다.";

	public boolean validateAnswer(String input) {
		if (input.equals(YES)) {
			return true;
		}

		if (input.equals(NO)) {
			return false;
		}

		throw new IllegalArgumentException(ANSWER_ERROR);
	}
}
