package pairmatching.util.validator;

import pairmatching.util.ErrorMessage;
import pairmatching.util.Symbol;

public class MenuValidator {
	public static final String MENU_FORMAT = "^(1|2|3|Q)$";

	public static void validateMenu(String input) {
		validateFormat(input);
	}

	private static void validateFormat(String input) {
		if (!input.matches(MENU_FORMAT)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT.getMessage());
		}

	}

}
