package pairmatching.constant;

public enum Notification {
	FILE_STATE_INVALID("[ERROR] 파일을 정상적으로 조회할 수 없습니다."),
	CREW_NAME_DUPLICATED("[ERROR] 파일을 정상적으로 조회할 수 없습니다."),
	NOT_SUPPORTED_FUNCTION("[ERROR] 지원하지 않는 기능입니다."),
	NOT_SUPPORTED_COURSE("[ERROR] 지원하지 않는 코스입니다."),
	NOT_SUPPORTED_LEVEL("[ERROR] 지원하지 않는 레벨입니다."),
	NOT_SUPPORTED_MISSION("[ERROR] 지원하지 않는 미션입니다."),
	NOT_GATHER_PAIR_CREW("[ERROR] 페어프로그래밍은 2명 혹은 3명끼리 가능합니다.");

	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
