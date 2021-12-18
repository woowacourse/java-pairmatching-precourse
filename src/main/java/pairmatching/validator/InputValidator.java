package pairmatching.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INVALID_ENTRY_MENU_CHOICE = ERROR_PREFIX + "존재 하지 않는 메뉴 항목입니다";
	public static final String INVALID_SUB_MENU_CHOICE = ERROR_PREFIX + "잘못된 입력입니다. 예: 과정, 레벨, 미션";

	public static final List<String> ENTRY_MENU_LIST = Arrays.asList("1", "2", "3", "Q");

	public static void validateEntryMenu(String input) {
		if (!ENTRY_MENU_LIST.contains(input)) {
			throw new IllegalArgumentException(INVALID_ENTRY_MENU_CHOICE);
		}
	}

	public static void validateSubMenu(String input) {
		String regExp = "^[\\w가-힣]*,\\s*[\\w가-힣]*,\\s*[\\w가-힣]*\\s*$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_SUB_MENU_CHOICE);
		}
	}
}
