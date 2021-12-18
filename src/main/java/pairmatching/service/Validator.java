package pairmatching.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Menu;

public class Validator {

	private static final String BLANK_STRING_ERROR_MESSAGE = "아무것도 입력되지 않았습니다.";
	private static final String INVALID_MENU = "유효하지 않은 명령입니다.";

	public static void checkEmptyString(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(BLANK_STRING_ERROR_MESSAGE);
		}
	}

	public static void checkRangeInMenu(String ret) {
		List<Menu> menus = Arrays.asList(Menu.values());
		List<String> menuValidInputs = menus.stream().map(Menu::toString).collect(Collectors.toList());
		if (!menuValidInputs.contains(ret)) {
			throw new IllegalArgumentException(INVALID_MENU);
		}
	}
}
