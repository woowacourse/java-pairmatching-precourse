package pairmatching.controller;

import pairmatching.exception.AlreadyExistPairException;
import pairmatching.exception.QuitProgramException;
import pairmatching.service.MatchingService;
import pairmatching.utils.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private static final int FIRST_FUNCTION_NUMBER = 1;
	private static final int SECOND_FUNCTION_NUMBER = 2;
	private static final int MAX_FUNCTION_NUMBER = 3;

	private final MatchingService matchingService;

	public MatchingController() {
		matchingService = new MatchingService();
	}

	public void getFunctionNumber() {
		String input = InputView.chooseFunction();
		try {
			Validator.validateFunctionNumber(input);
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
			matching();
			return;
		}
		if (number == SECOND_FUNCTION_NUMBER) {
			return;
		}
		if (number == MAX_FUNCTION_NUMBER) {
		}
	}

	private void matching() {
		try {
			String[] input = InputView.printProgramInformation().split(",");
			Validator.validateCourseLevelMission(input);
			matchPair(input);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			matching();
		}
	}

	private void matchPair(String[] input) {
		try {
			String course = input[0];
			String level = input[1];
			String mission = input[2];
			matchingService.matchPair(course, level, mission);
		} catch (AlreadyExistPairException e) {
			matchPair(input);
		}
	}
}
