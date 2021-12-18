package pairmatching;

import java.util.Arrays;

public class Validator {
	private static final String NOT_VALID_MENU_ERROR = "[ERROR] 없는 기능 종류입니다. 다시 입력해주세요.";
	private static String[] menu = {"1", "2", "3", "Q"};

	public static void notValidMenu(String input) {
		if (!Arrays.asList(menu).contains(input)) {
			throw new IllegalArgumentException(NOT_VALID_MENU_ERROR);
		}
	}
}
