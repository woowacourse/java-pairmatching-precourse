package pairmatching.validator;

import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.exception.NotFoundMatchingException;
import pairmatching.view.InputView;

public class MatchingValidator {

	public static void checkDuplicatedValidation(Level level, Matching matching) {
		if (matching.isExistLevel(level)) {
			InputView.askRematching();
		}
		return;
	}

	public static void isExistMatching(Level level, Matching matching){
		if(matching.isExistLevel(level)){
			return;
		}
		throw new NotFoundMatchingException();
	}
}
