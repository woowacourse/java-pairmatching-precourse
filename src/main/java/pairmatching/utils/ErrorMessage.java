package pairmatching.utils;

public enum ErrorMessage {
	ERROR_DUPLICATE_MSG("[ERROR] 파일에 중복된 이름이 있습니다."),
	ERROR_NAME_PATTERN_MSG("[ERROR] 이름은 한글 혹은 영어 대소문자만 가능합니다."),
	ERROR_EMPTY_INPUT_MSG("[ERROR] 빈 입력입니다."),
	ERROR_MATCH_INPUT_SIZE_MSG("[ERROR] 매칭 조회 입력은 과정, 레벨, 미션으로 입력해야 합니다. 레벨 3과 5의 경우 미션 이름 대신 아무글자나 입력하세요."),
	ERROR_NOT_IN_COURSE_MSG("[ERROR] 해당 과정은 없는 과정입니다."),
	ERROR_NOT_IN_LEVEL_MSG("[ERROR] 해당 레벨은 없는 레벨입니다."),
	ERROR_NOT_IN_MISSION_MSG("[ERROR] 해당 미션은 없는 미션입니다."),
	ERROR_YES_OR_NO_MSG("[ERROR] 재매치 입력은 항상 예 혹은 아니오로 입력해야 합니다.");


	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
