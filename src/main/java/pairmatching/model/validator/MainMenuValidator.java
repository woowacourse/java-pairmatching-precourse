package pairmatching.model.validator;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuValidator {

	public static final String IS_MENU_ERROR_MESSAGE = "[ERROR] 입력값이 메뉴에 없습니다.";

	public boolean validate(String input) {
		try {
			isMenu(input);
			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	private void isMenu(String input) throws IllegalArgumentException {
		String[] menuNum = {"1", "2", "3", "Q"};
		ArrayList<String> menuList = new ArrayList<>(Arrays.asList(menuNum));

		if (!menuList.contains(input)) {
			System.out.println(IS_MENU_ERROR_MESSAGE);
		}
	}
}
