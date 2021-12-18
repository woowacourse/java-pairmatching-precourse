package pairmatching.controller;

import pairmatching.exception.QuitProgramException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private static final String INVALID_FUNCTION = "[ERROR] 잘못된 기능 입력입니다.";
	private static final int FIRST_FUNCTION_NUMBER = 1;
	private static final int SECOND_FUNCTION_NUMBER = 2;
	private static final int MAX_FUNCTION_NUMBER = 3;

	public void getFunctionNumber() {
		String input = InputView.chooseFunction();
		try {
			validateFunctionNumber(input);
			if (input.equals("Q")) {
				throw new QuitProgramException();
			}
			chooseFunction(Integer.parseInt(input));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			getFunctionNumber();
		}
	}

	private void chooseFunction(int number) {
		if (number == FIRST_FUNCTION_NUMBER) {
			return;
		}
		if (number == SECOND_FUNCTION_NUMBER) {
			return;
		}
		if (number == MAX_FUNCTION_NUMBER) {
		}
	}

	private void validateFunctionNumber(String s) {
		try {
			int number = Integer.parseInt(s);
			if (number > MAX_FUNCTION_NUMBER) {
				throw new IllegalArgumentException(INVALID_FUNCTION);
			}
		} catch (NumberFormatException e) {
			if (s.equals("Q")) {
				return;
			}
			throw new IllegalArgumentException(INVALID_FUNCTION);
		}
	}
}
