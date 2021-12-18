package pairmatching.view;

public class OutputView {

	public static final String SELECT_MENU_INIT = "기능을 선택하세요.";
	public static final String MENU_PAIR_MATCHING = "1. 페어 매칭";
	public static final String MENU_CHECK_PAIR_RESULT = "2. 페어 조회";
	public static final String MENU_PAIR_CLEAR = "3. 페어 초기화";
	public static final String MENU_QUIT = "Q. 종료";

	public static void printMenu() {
		printMenuInit();
		printMenuCategories();
	}

	private static void printMenuInit() {
		System.out.println(SELECT_MENU_INIT);
	}

	private static void printMenuCategories() {
		System.out.println(MENU_PAIR_MATCHING);
		System.out.println(MENU_CHECK_PAIR_RESULT);
		System.out.println(MENU_PAIR_CLEAR);
		System.out.println(MENU_QUIT);
	}
}
