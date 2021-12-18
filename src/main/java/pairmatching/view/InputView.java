package pairmatching.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String ASK_FEATURE_INPUT = "기능을 선택하세요.";
	private static final String MATCHING_INPUT = "1. 페어 매칭";
	private static final String SEARCH_INPUT = "2. 페어 조회";
	private static final String INITIALIZING_INPUT = "3. 페어 초기화";
	private static final String QUIT_INPUT = "Q. 종료";

	private static final String HASH_LINE = "############################################";
	private static final String COURSE_LIST = "과정: 백엔드 | 프론트엔드";
	private static final String MISSION = "미션:";
	private static final String LEVEL_ONE = "- 레벨1: 자동차경주 | 로또 | 숫자야구게임";
	private static final String LEVEL_TWO = "- 레벨2: 장바구니 | 결제 | 지하철노선도";
	private static final String LEVEL_THREE = "- 레벨3:";
	private static final String LEVEL_FOUR = "- 레벨4: 성능개선 | 배포";
	private static final String LEVEL_FIVE = "- 레벨5:";
	private static final String ASK_MATCH_INFORMATION_INPUT = "과정, 레벨, 미션을 선택하세요.";
	private static final String ASK_MATCH_INFORMATION_EX = "ex) 백엔드, 레벨1, 자동차경주";

	public static int askFeature(){
		System.out.println(ASK_FEATURE_INPUT);
		System.out.println(MATCHING_INPUT);
		System.out.println(SEARCH_INPUT);
		System.out.println(INITIALIZING_INPUT);
		System.out.println(QUIT_INPUT);
		return Integer.parseInt(Console.readLine());
	}

	public static String askWantedMatchingInformation(){
		System.out.println(HASH_LINE);
		System.out.println(COURSE_LIST);
		System.out.println(MISSION);
		System.out.println(LEVEL_ONE);
		System.out.println(LEVEL_TWO);
		System.out.println(LEVEL_THREE);
		System.out.println(LEVEL_FOUR);
		System.out.println(LEVEL_FIVE);
		System.out.println(ASK_MATCH_INFORMATION_INPUT);
		System.out.println(ASK_MATCH_INFORMATION_EX);
		System.out.println(HASH_LINE);
		return Console.readLine();
	}
}
