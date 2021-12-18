package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String MENU = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";
	private static final String MENU_REGEX = "^[123Q]$";

	public static String getMenu() {
		System.out.println(MENU);
		return getMenuInput();
	}

	public static String getMenuInput() {
		String input = Console.readLine();
		if (!input.matches(MENU_REGEX)) {
			throw new IllegalArgumentException("[ERROR] 1,2,3,Q 중 하나를 입력하세요\n");
		}
		return input;
	}
}
