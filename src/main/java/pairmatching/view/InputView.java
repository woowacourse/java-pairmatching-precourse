package pairmatching.view;

import static pairmatching.view.ViewConstants.*;

public class InputView {
	public static void inputMainMenu() {
		System.out.println(MAIN_MENU);
	}

	public static void inputMatching() {
		System.out.println(DOMAIN);
		System.out.println(INPUT_MATCH_INFORMATION);
	}

	public static void reinputMatch() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
			+ "네 | 아니오");
	}
}
