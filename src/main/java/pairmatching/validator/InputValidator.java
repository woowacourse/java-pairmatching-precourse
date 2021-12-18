package pairmatching.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INVALID_ENTRY_MENU_CHOICE = ERROR_PREFIX + "존재 하지 않는 메뉴 항목입니다";

	public static void validateEntryMenu(String input) {
		List<String> menuList = Arrays.asList("1", "2", "3", "Q");
		if (!menuList.contains(input)) {
			throw new IllegalArgumentException(INVALID_ENTRY_MENU_CHOICE);
		}
	}
}
