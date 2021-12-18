package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Menu;

public class InputView {
	public static final String WRONG_MENU_CHOICE_INPUT = "잘못된 메뉴 정보를 입력하셨습니다.";

	public static String selectMenu() {
		String choice = Console.readLine();
		validateMenuChoiceInput(choice);

		return choice;
	}

	private static void validateMenuChoiceInput(String choice) {
		if (!Menu.contains(choice)) {
			throw new IllegalArgumentException(WRONG_MENU_CHOICE_INPUT);
		}
	}
}
