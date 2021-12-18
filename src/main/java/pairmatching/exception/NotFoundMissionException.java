package pairmatching.exception;

public class NotFoundMissionException extends IllegalArgumentException {
	public NotFoundMissionException() {
		super("[ERROR] 해당하는 미션을 찾을 수 없습니다.");
	}
}
