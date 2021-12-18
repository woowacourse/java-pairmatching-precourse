package pairmatching.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INVALID_ENTRY_MENU_CHOICE = ERROR_PREFIX + "존재 하지 않는 메뉴 항목입니다";
	public static final List<String> ENTRY_MENU_LIST = Arrays.asList("1", "2", "3", "Q");

	public static void validateEntryMenu(String input) {
		if (!ENTRY_MENU_LIST.contains(input)) {
			throw new IllegalArgumentException(INVALID_ENTRY_MENU_CHOICE);
		}
	}

	public static void validateCourseMenu(String input) {

	}
}
