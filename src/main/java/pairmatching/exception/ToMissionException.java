package pairmatching.exception;

public class ToMissionException extends IllegalArgumentException {
	private static final String MESSAGE = "미션 이름을 다시 입력해주세요.";

	public ToMissionException() {
		super(MESSAGE);
	}
}
