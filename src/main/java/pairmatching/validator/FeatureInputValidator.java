package pairmatching.validator;

import static constants.PairMatchingConstants.*;

public class FeatureInputValidator {
	public static void checkFeatureInput(String input) {
		isEmpty(input);
		isRightInput(input);
	}

	private static void isRightInput(String input) {
		if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")) {
			throw new IllegalArgumentException(WRONG_FEATURE_INPUT_ERROR);
		}
	}

	private static void isEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
		}
	}
}
