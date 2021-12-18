package pairmatching.exception;

public class ToLevelException extends IllegalArgumentException {
	private static final String MESSAGE = "레벨 명을 다시 입력해주세요.";

	public ToLevelException() {
		super(MESSAGE);
	}
}
