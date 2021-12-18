package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String MENU = "\n기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";
	private static final String MENU_REGEX = "^[123Q]$";
	private static final String ASKING_MATCHING = "과정, 레벨, 미션을 선택하세요.";
	private static final String ASKING_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";

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

	public static String getMatchingInput() {
		System.out.println(ASKING_MATCHING);
		return Console.readLine();
	}

	public static String getOriginOrRematchNumber() {
		try {
			System.out.println(ASKING_REMATCHING);
			String input = Console.readLine();
			if (!input.matches(MENU_REGEX)) {
				throw new IllegalArgumentException("[ERROR] 네, 아니오 둘 중 하나를 입력하세요.");
			}
			return input;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getOriginOrRematchNumber();
		}
	}
}
