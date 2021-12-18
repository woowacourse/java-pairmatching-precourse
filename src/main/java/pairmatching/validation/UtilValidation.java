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
}
