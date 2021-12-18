package pairmatching.exception;

public class NoMissionException extends IllegalArgumentException {
	private static final String ERROR_MESSAGE = "일치하는 미션 이 없습니다.";

	public NoMissionException() {
		super(ERROR_MESSAGE);
	}
}
