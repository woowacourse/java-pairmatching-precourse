package pairmatching.constant;

public enum Notification {
	FILE_STATE_INVALID("[ERROR] 파일을 정상적으로 조회할 수 없습니다."),
	CREW_NAME_DUPLICATED("[ERROR] 파일을 정상적으로 조회할 수 없습니다."),
	NOT_SUPPORTED_FUNCTION("[ERROR] 지원하지 않는 기능입니다.");

	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
