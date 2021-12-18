package pairmatching.type;

public enum Notice {
	WOOWACOURSE_INFO_START("#############################################"),
	WOOWACOURSE_INFO_END("############################################"),
	WOOWACOURSE_INFO_SPLIT(" | "),
	WOOWACOURSE_INFO_LIST("  - "),
	EQUALS(": "),
	PAIR_IS(" : "),

	SELECT_FUNCTION("기능을 선택하세요.\n"
		+ PairMatchingType.MATCH.getNumber() + ". 페어 매칭\n"
		+ PairMatchingType.VIEW.getNumber() + ". 페어 조회\n"
		+ PairMatchingType.RESET.getNumber() + ". 페어 초기화\n"
		+ PairMatchingType.QUIT.getString() + ". 종료"),

	WOOWACOURSE_COURSE_TITLE("과정: "),
	WOOWACOURSE_MISSION_TITLE("미션:"),

	INPUT_PAIRMACHING("과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주"),

	REMATCH("매칭 정보가 있습니다. 다시 매칭하시겠습니까?"),

	MATCHING_RESULT("페어 매칭 결과입니다.");

	private String string;

	Notice(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}
}
