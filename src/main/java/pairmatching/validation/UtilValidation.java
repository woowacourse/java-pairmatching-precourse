package pairmatching.validation;

import static pairmatching.constants.ErrorMessage.*;

public class UtilValidation {
	public static void isNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException numberFormatException) {
			throw (new IllegalArgumentException(ERROR_BE_NUMBER));
		}
	}

	public static String[] isCourseInput(String input) {
		String[] split = input.split(", ");
		if (!(split.length == 3)) {
			throw (new IllegalArgumentException(NOT_COUSE_FORM));
		}
		return split;
	}
}
