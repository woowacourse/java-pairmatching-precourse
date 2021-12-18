package pairmatching.view;

public class InputFormatValidator {
	private static final int MAIN_OPTION_COUNT = 3;
	private static final String NOT_INT_ERROR_MSG = "숫자 또는 Q를 입력해주세요.";
	private static final String INVALID_RANGE_ERROR_MSG = "기능 번호를 확인해주세요.";

	public static String validateOptionFormat(String option) throws IllegalArgumentException {
		if (!option.equals("Q")) {
			int optionNum = transferToInt(option);
			validateRange(optionNum);
		}
		return option;
	}

	private static int transferToInt(String option) throws IllegalArgumentException {
		try {
			return Integer.parseInt(option);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_INT_ERROR_MSG);
		}
	}

	private static void validateRange(int optionNum) throws IllegalArgumentException {
		if (optionNum <= 0 || optionNum > MAIN_OPTION_COUNT) {
			throw new IllegalArgumentException(INVALID_RANGE_ERROR_MSG);
		}
	}
}
