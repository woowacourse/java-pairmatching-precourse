package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Function;

public class Input {
	private static final String FUNCTION_SELECT_TEXT = "기능을 선택하세요.";

	public static Function requestFunctionSelect() {
		printFunctions();
		return readFunctionSelect();
	}

	private static void printFunctions() {
		System.out.println(FUNCTION_SELECT_TEXT);
		Function.getFunctionList().forEach(System.out::println);
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
}
