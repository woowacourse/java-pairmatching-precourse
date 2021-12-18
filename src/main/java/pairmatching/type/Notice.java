package pairmatching.type;

public enum Notice {
	WOOWACOURSE_INFO_START("#############################################"),
	WOOWACOURSE_INFO_END("############################################"),
	WOOWACOURSE_INFO_SPLIT(" | "),
	WOOWACOURSE_INFO_LIST("  - "),
	EQUALS(": "),

	SELECT_FUNCTION("기능을 선택하세요.\n"
		+ PairMatchingType.MATCH.getNumber() + ". 페어 매칭\n"
		+ PairMatchingType.VIEW.getNumber() + ". 페어 조회\n"
		+ PairMatchingType.RESET.getNumber() + ". 페어 초기화\n"
		+ PairMatchingType.QUIT.getString() + ". 종료"),

	WOOWACOURSE_COURSE_TITLE("과정: "),
	WOOWACOURSE_MISSION_TITLE("미션:");

	private String string;

	Notice(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}
}
