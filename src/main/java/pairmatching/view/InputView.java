package pairmatching.view;

public class InputView {
	public static final String SELECT_FUNCTION_MESSAGE = "기능을 선택하세요.";
	public static final String PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
	public static final String PAIR_CHECK_MESSAGE = "2. 페어 조회";
	public static final String PAIR_INITIALIZATION_MESSAGE = "3. 페어 초기화";
	public static final String PAIR_EXIT_MESSAGE = "Q. 종료";

	public static final String LINE_SIGN = "#############################################";
	public static final String COURSE_MESSAGE = "과정: 백엔드 | 프론트엔드";
	public static final String MISSION_LEVEL_MESSAGE = "미션:\n"
		+ "\t  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "\t  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "\t  - 레벨3:\n"
		+ "\t  - 레벨4: 성능개선 | 배포\n"
		+ "\t  - 레벨5:";
	public static final String SELECT_COURSE_MISSION_LEVEL_MESSAGE = "과정, 레벨, 미션을 선택하세요.";

	public static void askSelectFunction() {
		System.out.println(SELECT_FUNCTION_MESSAGE);
		System.out.println(PAIR_MATCHING_MESSAGE);
		System.out.println(PAIR_CHECK_MESSAGE);
		System.out.println(PAIR_INITIALIZATION_MESSAGE);
		System.out.println(PAIR_EXIT_MESSAGE);
	}

	public static void askCourseLevelMission() {
		System.out.println(LINE_SIGN);
		System.out.println(COURSE_MESSAGE);
		System.out.println(MISSION_LEVEL_MESSAGE);
		System.out.println(LINE_SIGN);
		System.out.println(SELECT_COURSE_MISSION_LEVEL_MESSAGE);
	}
}
