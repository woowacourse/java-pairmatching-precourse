package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.FunctionSelectionNumberValidator;
import utils.validator.ProcessAndLevelAndMissionValidator;

public class InputController {

	private InputController() {
	}

	public static String inputFunctionSelectionNumber() {
		while (true) {
			try {
				return FunctionSelectionNumberValidator.checkValidNumber(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static List<String> inputProcessAndLevelAndMission() {
		while (true) {
			try {
				return ProcessAndLevelAndMissionValidator.checkValidInformation(
					Arrays.stream(Console.readLine().split(",")).map(String::trim).collect(Collectors.toList()));
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
