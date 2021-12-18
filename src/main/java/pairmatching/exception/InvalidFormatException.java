package pairmatching.exception;

public class InvalidFormatException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "올바르지 않은 입력 형식입니다.";

	public InvalidFormatException() {
		super(ERROR_MESSAGE);
	}
}
