package pairmatching.view;

public class DomainMessage {

	public static final String SEPARATING_WALL = "#############################################";
	public static final String COURSE_LIST = "과정: 백엔드 | 프론트엔드";
	public static final String MISSION_LIST = "미션:";
	public static final String MISSION_LEVEL1 = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
	public static final String MISSION_LEVEL2 = "  - 레벨2: 장바구니 | 결제 | 지하철노선도";
	public static final String MISSION_LEVEL3 = "  - 레벨3: ";
	public static final String MISSION_LEVEL4 = "  - 레벨4: 성능개선 | 배포";
	public static final String MISSION_LEVEL5 = "  - 레벨5: ";
	public static final String MANUAL_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	public static final String INPUT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";

	public static void printDomainInformation() {
		System.out.println();
		System.out.println(SEPARATING_WALL);
		System.out.println(COURSE_LIST);
		System.out.println(MISSION_LIST);
		System.out.println(MISSION_LEVEL1);
		System.out.println(MISSION_LEVEL2);
		System.out.println(MISSION_LEVEL3);
		System.out.println(MISSION_LEVEL4);
		System.out.println(MISSION_LEVEL5);
		System.out.println(SEPARATING_WALL);
	}

	public static void printManual() {
		System.out.println(MANUAL_MESSAGE);
		System.out.println(INPUT_EXAMPLE);
	}
}
