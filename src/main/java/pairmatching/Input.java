package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;

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

	public static void requestToSelectMission() {
		Printer.printMissions();
		Printer.printMissionInputRequest();
		readMissionSelected();
	}

	private static void readMissionSelected() {
		try {
			String input = Console.readLine();
			InputValidator.validateMissionInputContainsThreeElements(input);
			InputValidator.validateAllowedOption(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			readMissionSelected();
		}
	}
}
