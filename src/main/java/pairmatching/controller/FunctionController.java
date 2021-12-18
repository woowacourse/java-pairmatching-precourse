package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.FunctionValidator;

public class FunctionController {

	public static String getFunction() {
		String inputString = Console.readLine();
		try {
			FunctionValidator.validateInputForm(inputString);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			return getFunction();
		}
		return inputString;
	}
}
