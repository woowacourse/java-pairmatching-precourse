package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String SELECT_MENU_MSG = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	public static String inputMenu() {
		while (true) {
			try {
				System.out.println(SELECT_MENU_MSG);
				String inputMenu = Console.readLine();
				Validator.notValidMenu(inputMenu);
				return inputMenu;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
