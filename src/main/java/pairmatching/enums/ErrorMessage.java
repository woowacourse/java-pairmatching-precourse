package pairmatching.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	INPUT_EXECUTE_FEATURE_ERROR("기능 선택 입력을 잘못했습니다."),
	NO_FILE_CREW_ERROR("크루 파일이 없습니다."),
	LEVEL_GET_BY_VALUE_ERROR("레벨을 잘못입력했습니다."),
	NO_HAS_MISSION_ERROR("미션이 없습니다."),
	NO_HAS_PAIRS_ERROR("페어가 없습니다."),
	REMATCHING_INPUT_ERROR("네 | 아니오 로 답해주세요");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return ERROR_MESSAGE.message + this.message;
	}
}
