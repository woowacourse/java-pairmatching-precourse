package pairmatching.data;

import java.util.Arrays;
import java.util.List;

public class ProgramData {
	public static final String BACKEND_CREW_FILEPATH = "src/main/resources/backend-crew.md";
	public static final String FRONTEND_CREW_FILEPATH = "src/main/resources/frontend-crew.md";

	public static final String SELECT_MESSAGE = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	public static final String PAIR_MATCH_RESULT_MESSAGE = "페어 매칭 결과입니다.";
	public static final String PAIR_SEPARATOR = " : ";

	public static final List<String> LEVEL1_MISSION = Arrays.asList("자동차경주", "로또", "숫자야구게임");
	public static final List<String> LEVEL2_MISSION = Arrays.asList("장바구니", "결제", "지하철노선도");
	public static final List<String> LEVEL3_MISSION = Arrays.asList();
	public static final List<String> LEVEL4_MISSION = Arrays.asList("성능개선", "배포");
	public static final List<String> LEVEL5_MISSION = Arrays.asList();

}
