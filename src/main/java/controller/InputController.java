package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.FunctionSelectionNumberValidator;

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
		return Arrays.stream(Console.readLine().split(",")).collect(Collectors.toList());
	}
}
