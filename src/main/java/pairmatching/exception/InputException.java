package pairmatching.exception;

public class InputException {

	private static final String INVALID_INPUT = "[ERROR] 유효하지 않은 기능입니다. 메뉴를 보고 다시 선택해주세요. ";

	public static void printInvalidInputError() {
		throw new IllegalArgumentException(INVALID_INPUT);
	}
}
