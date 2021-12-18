package pairmatching.util;

import java.util.List;

import pairmatching.domain.Menu;

public class MenuValidator extends Validator {
	public static void isRightMenu(String input) {
		isEmpty(input);
		isContainsMenu(input);
	}

	private static void isContainsMenu(String input) {
		List<String> menus = Menu.getAllMenus();

		if (!menus.contains(input)) {
			throw new IllegalArgumentException("존재하는 메뉴를 입력해주세요.");
		}
	}
}
