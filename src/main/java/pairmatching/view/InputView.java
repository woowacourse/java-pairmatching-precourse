package pairmatching.view;

import static java.lang.System.*;
import static pairmatching.constant.message.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.InputValidator;

public class InputView {

	public static String chooseEntryMenu() {
		out.println(INPUT_ENTRY_MENU);
		String input;
		out.println();
		while (true) {
			try {
				input = Console.readLine();
				InputValidator.validateEntryMenu(input);
				return input;
			} catch (Exception e) {
				out.println(e.getMessage());
				continue;
			}
		}
	}

	public static String inputMatching() {
		String input;
		while (true) {
			try {
				input = commonSubMenuInput();
				InputValidator.validateMatching(input);
				return input;
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}

	public static String inputRetrieve() {
		return commonSubMenuInput();
	}

	public static String commonSubMenuInput() {
		out.println(INPUT_COURSE_MENU);
		String input = Console.readLine();
		out.println();
		return input;
	}
}
