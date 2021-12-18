package pairmatching.enums;

public enum ErrorMessage {
	ERROR_MESSAGE("[ERROR] "),
	INPUT_EXECUTE_FEATURE_ERROR("기능 선택 입력을 잘못했습니다."),
	NO_FILE_CREW_ERROR("크루 파일이 없습니다."),
	LEVEL_GET_BY_VALUE_ERROR("레벨을 잘못입력했습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return ERROR_MESSAGE.message + this.message;
	}
}
