package pairmatching.util;

public enum ViewMessage {
	SELECT_MENU_MSG("기능을 선택하세요."),
	ENTER_COURSE_INFO_MSG("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주"),
	START_END_PRINT_INFO("#############################################");


	private final String message;

	ViewMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
