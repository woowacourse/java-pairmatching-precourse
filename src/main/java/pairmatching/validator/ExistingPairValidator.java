package pairmatching.validator;

import static constants.PairMatchingConstants.*;

public class ExistingPairValidator {
	public static void checkInput(String input) {
		isEmpty(input);
		isRightInput(input);

	}

	private static void isEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
		}
	}

	private static void isRightInput(String input) {
		if (!input.equals(YES) && !input.equals(NO)) {
			throw new IllegalArgumentException(WRONG_INPUT_ERROR);
		}
	}
}
