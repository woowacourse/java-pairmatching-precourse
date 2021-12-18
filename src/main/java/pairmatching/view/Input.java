package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static pairmatching.validator.Validator.*;

public class Input {

	public static String inputFunction() {
		String input = readLine();
		if (!isValidatedFunction(input)) {
			input = readLine();
		}

		return input;
	}

	public static String inputSetPairMatching() {
		String input = readLine();
		// TODO: 검증

		return input;
	}

	public static String inputViewPairMatching() {
		String input = readLine();
		// TODO: 검증

		return input;
	}

	public static String inputRestart() {
		String input = readLine();
		// TODO: 검증

		return input;
	}
}
