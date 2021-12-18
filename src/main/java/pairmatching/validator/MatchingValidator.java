package pairmatching.validator;

import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.view.InputView;

public class MatchingValidator {

	public static void checkDuplicatedValidation(Level level, Matching matching) {
		//존재하지 않는다면
		if (matching.isExsistLevel(level)) {
			return;
		}
		InputView.askRematching();
	}
}
