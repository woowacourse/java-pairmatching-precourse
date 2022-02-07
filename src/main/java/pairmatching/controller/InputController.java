package pairmatching.controller;

import pairmatching.utils.validator.MainValidator;
import pairmatching.utils.validator.MissionValidator;
import pairmatching.utils.validator.RematchingValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InputController {
	public static final String REGEX = ", ";

	public static String getMain() {
		try {
			String input = InputView.mainInput();
			new MainValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMain();
		}
	}

	public static String getRePairMatch() {
		try {
			String input = InputView.rematchingInput();
			new RematchingValidator(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getMain();
		}
	}

	public static String[] getPairMatch() {
		try {
			String input = InputView.wantedMissionInput();
			new MissionValidator(input);
			return input.split(REGEX);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getPairMatch();
		}
	}
}
