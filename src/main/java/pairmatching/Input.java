package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;

public class Input {
	public static Function requestToSelectFunction() {
		Printer.printFunctions();
		return readFunctionSelect();
	}

	private static Function readFunctionSelect() {
		try {
			String input = Console.readLine();
			InputValidator.validateAllowedFunction(input);
			return Function.byKey(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readFunctionSelect();
		}
	}

	public static void requestToSelectMission() {
		Printer.printMissions();
	}
}
