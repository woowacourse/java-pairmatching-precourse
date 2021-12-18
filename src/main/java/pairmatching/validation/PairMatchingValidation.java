package pairmatching.validation;

import static pairmatching.constants.ErrorMessage.*;

public class PairMatchingValidation {
	public static void isFunctionNumber(String input) {
		int functionNumber = Integer.parseInt(input);
		if (!(functionNumber > 0 && functionNumber < 4)) {
			throw new IllegalArgumentException(NOT_INTO_RANGE);
		}
	}
}
