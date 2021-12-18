package pairmatching.validator;

import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.view.InputView;

public class MatchingValidator {

	public static void checkDuplicatedValidation(Level level, Matching matching) {
		if (matching.isExsistLevel(level)) {
			InputView.askRematching();
		}
		return;
	}
}
