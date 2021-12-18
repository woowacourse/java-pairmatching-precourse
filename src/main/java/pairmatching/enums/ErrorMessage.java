package pairmatching.enums;

public enum ErrorMessage {
	ERROR_MESSAGE(""),
	INPUT_EXECUTE_FEATURE_ERROR("기능 선택 입력을 잘못했습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String get() {
		return message;
	}
}
