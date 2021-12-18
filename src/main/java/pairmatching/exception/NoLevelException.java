package pairmatching.exception;

public class NoLevelException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "일치하는 레벨이 없습니다.";

	public NoLevelException() {
		super(ERROR_MESSAGE);
	}
}
