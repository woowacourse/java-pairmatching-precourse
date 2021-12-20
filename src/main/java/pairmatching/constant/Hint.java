package pairmatching.constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Hint {
	HINT_FUNCTION_SELECTION("기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료"),
	HINT_MATCH_INFO_INPUT("#############################################\n"
		+ "과정: "
		+ Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.joining(" | "))
		+ "\n미션:\n"
		+ Arrays.stream(Level.values())
		.map(level -> String.format("  - %s: %s", level.getName(), String.join(" | ", MissionName.ofLevel(level))))
		.collect(Collectors.joining("\n"))
		+ "\n############################################\n"
		+ "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주"),
	HINT_PAIR_MATCHING_RESULT("페어 매칭 결과입니다."),
	HINT_CLEARED("초기화 되었습니다."),
	HINT_REMATCHING("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오");

	private static final String MISSION_FORMAT = "  - %s: %s\n";
	private static final String COURSE_FORMAT = "과정: %s\n";

	private final String hint;

	Hint(String hint) {
		this.hint = hint;
	}

	public String getHint() {
		return hint;
	}
}
