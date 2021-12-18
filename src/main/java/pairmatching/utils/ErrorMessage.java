package pairmatching.utils;

public enum ErrorMessage {
	ERROR_DUPLICATE_MSG("[ERROR] 파일에 중복된 이름이 있습니다."),
	ERROR_NAME_PATTERN_MSG("[ERROR] 이름은 한글 혹은 영어 대소문자만 가능합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
