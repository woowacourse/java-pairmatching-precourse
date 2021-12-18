package pairmatching.util;

public enum ErrorMessage {
	INVALID_MENU_INPUT("[ERROR] 잘못된 메뉴 입력입니다 1,2,3,Q 중 하나를 입력하세"),
	INVALID_FORMAT("[ERROR] 잘못된 형식을 입력하셨습니다."),
	INVALID_LEVEL_INPUT("[ERROR] 잘못된 Level을 입력하셨습니다."),
	INVALID_MISSION_INPUT("[ERROR] 잘못된 Mission을 입력하셨습니다."),
	NOT_MATCHING_MISSION("[ERROR] 아직 매칭되지 않은 미션입니다."),
	INVALID_COURSE_NAME("[ERROR] 잘못된 Course 이름입니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
