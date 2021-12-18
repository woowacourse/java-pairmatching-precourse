package pairmatching.exception;

public class NotFoundLevelException extends IllegalArgumentException {
	public NotFoundLevelException() {
		super("[ERROR] 해당하는 레벨을 찾을 수 없습니다.");
	}
}
