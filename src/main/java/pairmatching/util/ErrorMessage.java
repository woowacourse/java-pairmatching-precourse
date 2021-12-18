package pairmatching.util;

public enum ErrorMessage {
	INVALID_MENU_INPUT("[ERROR] 잘못된 메뉴 입력입니다 1,2,3,Q 중 하나를 입력하세");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
