package pairmatching.model.validator;

public class RePairMatchingAskValidator {

	public static final String IS_PROPER_ERROR_MESSAGE = "[ERROR] 적절한 대답이 아닙니다.";

	public boolean validate(String input) {
		try {
			isProper(input);
			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	private void isProper(String input) throws IllegalArgumentException {
		if (!input.equals("네") && !input.equals("아니오")) {
			System.out.println(IS_PROPER_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}
}
