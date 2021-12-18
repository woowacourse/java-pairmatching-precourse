package pairmatching.validator;

import static constants.PairMatchingConstants.*;

public class FeatureInputValidator {
	public static void checkFeatureInput(String input) {
		isEmpty(input);
		isRightInput(input);
	}

	private static void isRightInput(String input) {
		if (!input.equals(PAIR_MATCHING) && !input.equals(PAIR_LOOKUP) && !input.equals(PAIR_RESET) && !input.equals(
			QUIT)) {
			throw new IllegalArgumentException(WRONG_FEATURE_INPUT_ERROR);
		}
	}

	private static void isEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
		}
	}
}
