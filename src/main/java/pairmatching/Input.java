package pairmatching;

import static pairmatching.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.SelectedMission;

public class Input {
	public static Function requestToSelectFunction() {
		Printer.printFunctions();
		return readFunctionSelected();
	}

	private static Function readFunctionSelected() {
		try {
			String input = Console.readLine();
			InputValidator.validateAllowedFunction(input);
			return Function.byKey(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readFunctionSelected();
		}
	}

	public static SelectedMission requestToSelectMission() {
		Printer.printMissionInputRequest();
		return readMissionSelected();
	}

	private static SelectedMission readMissionSelected() {
		try {
			String input = Console.readLine();
			String[] elements = input.split(COMMA);

			InputValidator.validateMissionInputContainsThreeElements(input);
			InputValidator.validateAllowedOption(elements);
			return new SelectedMission(Course.byName(elements[0]), Level.byName(elements[1]), Mission.byName(elements[2]));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readMissionSelected();
		}
	}

	public static boolean requestMatchingAgain() {
		Printer.printMatchingAgain();
		return readMatchingAgain();
	}

	private static boolean readMatchingAgain() {
		try {
			String input = Console.readLine();
			InputValidator.validateYesOrNo(input);
			return input.equals(YES);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readMatchingAgain();
		}
	}
}
