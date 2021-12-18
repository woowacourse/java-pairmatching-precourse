package pairmatching.view;

public class OutputView {

	private static final String SELECT_MENU = "기능을 선택하세요.";
	private static final String SELECT_MENU_ONE = "1. 페어 매칭";
	private static final String SELECT_MENU_TWO = "2. 페어 조회";
	private static final String SELECT_MENU_THREE = "3. 페어 초기화";
	private static final String SELECT_MENU_END = "Q. 종료";

	public static void printInputMainMenu() {
		System.out.println(SELECT_MENU);
		System.out.println(SELECT_MENU_ONE);
		System.out.println(SELECT_MENU_TWO);
		System.out.println(SELECT_MENU_THREE);
		System.out.println(SELECT_MENU_END);
	}

	public static void printException(Exception exception) {
		System.out.println("[ERROR] " + exception.getMessage());
	}
}
