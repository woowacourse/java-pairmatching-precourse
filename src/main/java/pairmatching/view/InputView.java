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
		while (true) {
			out.println(INPUT_COURSE_MENU);
			String input = Console.readLine();
			try {
				InputValidator.validateMatching(input);
				out.println();
				return input;
			} catch (Exception e) {
				out.println(e.getMessage());
				continue;
			}
		}
	}

	public static String inputRetrieve() {
		out.println(INPUT_COURSE_MENU);
		String input = Console.readLine();
		out.println();
		return input;
	}

	public static String getMatchingAgain() {
		while (true) {
			try {
				out.println(INPUT_MATCHING_AGAIN);
				String input = Console.readLine();
				InputValidator.validateMatchingAgain(input);
				return input;
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}
}
