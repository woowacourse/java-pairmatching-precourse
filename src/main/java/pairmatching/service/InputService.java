package pairmatching.service;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.Validator;
import pairmatching.view.OutputView;

public class InputService {
	public static String input(Validator validator) {
		String line;
		try {
			line = Console.readLine();
			validator.exceptionInvalid(line);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			line = input(validator);
		}
		return line;
	}
}
