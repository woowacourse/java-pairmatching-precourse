package pairmatching.util;

public enum ViewMessage {
	SELECT_MENU_MSG("기능을 선택하세요."),
	START_END_PRINT_INFO("#############################################");


	private final String message;

	ViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
