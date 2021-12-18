package pairmatching.util;

public enum ErrorMessage {
	ERROR("[ERROR]"),
	NOT_NUMBER_ERROR("숫자를 입력해야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
