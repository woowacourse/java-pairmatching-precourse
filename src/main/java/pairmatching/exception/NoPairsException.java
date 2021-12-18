package pairmatching.exception;

public class NoPairsException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "일치하는 페어정보가 없습니다.";

	public NoPairsException() {
		super(ERROR_MESSAGE);
	}
}
