package pairmatching.validator;

import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.exception.NotFoundMatchingException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingValidator {

	public static void checkDuplicatedValidation(Level level, Matching matching) {
		if (matching.isExsistLevel(level)) {
			InputView.askRematching();
		}
		return;
	}

	public static void isExistMatching(Level level, Matching matching){
		if(matching.isExsistLevel(level)){
			return;
		}
		throw new NotFoundMatchingException();
	}
}
