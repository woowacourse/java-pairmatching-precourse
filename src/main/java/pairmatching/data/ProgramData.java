package pairmatching.data;

import java.util.Arrays;
import java.util.List;

public class ProgramData {
	public static final String BACKEND_CREW_FILEPATH = "src/main/resources/backend-crew.md";
	public static final String FRONTEND_CREW_FILEPATH = "src/main/resources/frontend-crew.md";

	public static final String SELECT_MESSAGE = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	public static final String DUPLICATE_PAIR_SELECT_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
	public static final String PAIR_MATCH_RESULT_MESSAGE = "페어 매칭 결과입니다.";
	public static final String SELECT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	public static final String PAIR_SEPARATOR = " : ";
	public static final String BAR_SEPARATOR = " | ";
	public static final String NEWLINE_SEPARATOR = "\n";
	public static final String COURSE_LEVEL_MISSION_SEPARATOR = ", ";

	public static final String LINE = "#############################################";
	public static final String COURSE_LIST_FORMAT = "과정 : %s";
	public static final String MISSION_INFO_MESSAGE = "미션 : \n%s";
	public static final String LEVEL_INFO_FORMAT = "  - %s: %s";

	public static final List<String> LEVEL1_MISSION = Arrays.asList("자동차경주", "로또", "숫자야구게임");
	public static final List<String> LEVEL2_MISSION = Arrays.asList("장바구니", "결제", "지하철노선도");
	public static final List<String> LEVEL3_MISSION = Arrays.asList();
	public static final List<String> LEVEL4_MISSION = Arrays.asList("성능개선", "배포");
	public static final List<String> LEVEL5_MISSION = Arrays.asList();

	public static final List<String> SELECT_LIST = Arrays.asList("1", "2", "3", "Q");
	public static final List<String> DUPLICATE_PAIR_SELECT_LIST = Arrays.asList("네", "아니오");
	public static final String YES = "네";

	public static final String INVALID_SELECT_ERROR = "[ERROR] 유효하지 않은 선택입니다.";
	public static final String PAIR_MATCH_FAIL_ERROR = "[ERROR] 크루 페어 매칭에 실패했습니다.";

	public static final int PAIR_MATCH_REPEAT = 3;

	public static final String SELECT_MATCH = "1";
	public static final String SELECT_LOOKUP = "2";
	public static final String SELECT_INIT = "3";
	public static final String PROGRAM_EXIT = "Q";

}
