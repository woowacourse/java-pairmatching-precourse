package pairmatching.validator;

import pairmatching.domain.Matching;
import pairmatching.exception.InputException;
import pairmatching.service.MatchingService;
import pairmatching.view.OutputView;

public class InputValidator {

	public static void checkInputValidation(String input) {
		if ("1".equals(input) || "2".equals(input) || "3".equals(input) || "Q".equals(input)) {
			return;
		}
		InputException.printInvalidInputError();
	}

	public static void checkRematching(String input) {
		Matching matching = new Matching();
		MatchingService matchingService = new MatchingService();
		if ("네".equals(input)) {
			matchingService.generateRandomMatching(input);
		}
		if ("아니오".equals(input)) {
			OutputView.printMatchingInfo(matching);
		}
	}

}
