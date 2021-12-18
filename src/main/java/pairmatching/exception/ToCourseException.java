package pairmatching.exception;

public class ToCourseException extends IllegalArgumentException {
	private static final String MESSAGE = "과정 이름을 다시 입력해주세요.";

	public ToCourseException() {
		super(MESSAGE);
	}
}
