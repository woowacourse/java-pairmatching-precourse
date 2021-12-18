package pairmatching.constant;

public final class PromptConstants {
	public static final String ASK_FUNCTION_PROMPT = "기능을 선택하세요.";
	public static final String ASK_FUNCTION_LIST_PROMPT = "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";
	public static final String PAIR_MATCHING_BOARD = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";
	public static final String ASKING_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
	public static final String ASKING_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까? \n 네 | 아니오";
	public static final String CLEAN_PROMPT = "초기화 되었습니다.";
}
