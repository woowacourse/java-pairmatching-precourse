package controller;

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
}
