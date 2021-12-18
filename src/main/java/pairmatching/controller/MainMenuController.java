package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Menu;
import pairmatching.service.Validator;
import pairmatching.view.ErrorMessage;
import pairmatching.view.MainMenuView;

public class MainMenuController {
	public static void mainMenuStart() {
		while (true) {
			String input = getMenuInput();
			if (input.equals(Menu.QUIT.toString())) {
				return;
			}
			navigate(input);
		}

	}

	private static void navigate(String input) {
		if (input.equals(Menu.PAIR_INIT.toString())) {

		} else if (input.equals(Menu.PAIR_MATCHING.toString())) {

		} else if (input.equals(Menu.PAIR_SHOW.toString())) {

		}
	}

	private static String getMenuInput() {
		try {
			MainMenuView.print();
			String input = Console.readLine();
			validateInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return getMenuInput();
		}
	}

	private static void validateInput(String input) {
		Validator.checkEmptyString(input);
		Validator.checkRangeInMenu(input);
	}
}
