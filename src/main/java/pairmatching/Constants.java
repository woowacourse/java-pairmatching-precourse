package pairmatching;

public class Constants {
	public static final String ERROR = "[ERROR]";
	public static final String MAIN_MENU = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";
	public static final String DOMAIN = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";
	public static final String INPUT_MATCH_INFORMATION = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	public static final String ERROR_INVALID_FORMAT = "입력 형식이 잘못됐습니다.";
	public static final String QUIT = "Q";
	public static final String MAKE_PAIR = "1";
	public static final String SEARCH_PAIR = "2";
	public static final String CLEAR_PAIR = "3";
	public static final String NO = "아니오";
	public static final String YES = "네";
	public static final String REINPUT = "다시 입력해주세요";
	public static final String NO_EXIST_COURSE = "존재하지 않는 과정입니다.";
	public static final String NO_EXIST_LEVEL = "존재하지 않는 레벨입니다.";
	public static final String NO_EXIST_MISSION = "존재하지 않는 미션입니다.";
	public static final String NO_EXIST_PAIR = "페어 정보가 존재하지 않습니다.";
	public static final int MAX_TRIAL = 3;
	public static final String FAIL_UNTIL_MAX_TRIAL = "3회 이상 매칭 실패.";
	public static final String COMMA = ",";
	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;
	public static final String COLON = " : ";
	public static final String PATTERN = "^[가-힣a-zA-Z0-9]+,\\s[가-힣a-zA-Z0-9]+,\\s[가-힣a-zA-Z0-9]+";
	public static final String NO_MENU = "그런 메뉴 없습니다.";
	public static final String REINPUT_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";
	public static final String MATCH_RESULT_MESSAGE = "페어 매칭 결과입니다.";
	public static final String CLEAR_MESSAGE = "초기화 되었습니다.";
	public static final String BACKEND_PATH = "./src/main/resources/backend-crew.md";
	public static final String FRONTEND_PATH = "./src/main/resources/frontend-crew.md";
}
