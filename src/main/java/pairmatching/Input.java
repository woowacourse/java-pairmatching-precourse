package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;

public class Input {
	private static final String MISSION_INPUT_REQUEST_STRING = "과정, 레벨, 미션을 선택하세요.";

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
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			readMissionSelected();
		}
	}
}
