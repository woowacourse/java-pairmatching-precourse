package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.input.Function;

public class InputView {
	private static final String NOTICE_INPUT_FUNCTION_NUMBER = "기능을 선택하세요.";

	public static String getFunctionNumber() {
		System.out.println(NOTICE_INPUT_FUNCTION_NUMBER);
		showFunctionList();
		return Console.readLine();
	}

	private static void showFunctionList() {
		for (Function function : Function.values()) {
			System.out.println(function);
		}
	}
}
