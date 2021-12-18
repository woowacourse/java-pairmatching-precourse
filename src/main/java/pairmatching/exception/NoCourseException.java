package pairmatching.exception;

public class NoCourseException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "일치하는 과정이 없습니다.";

	public NoCourseException() {
		super(ERROR_MESSAGE);
	}
}
