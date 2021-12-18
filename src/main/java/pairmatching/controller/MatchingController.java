package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.MatchingValidator;
import pairmatching.view.MatchingMessage;

public class MatchingController {
	public static String askRematching() {
		MatchingMessage.printManual();
		String inputString = Console.readLine();
		try {
			MatchingValidator.validateInputForm(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return askRematching();
		}
		return inputString;
	}
}
