package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.FunctionValidator;

public class InputView {
	public static final String SELECT_FUNCTION = "기능을 선택하세요.";
	public static final String MAIN_MATCH_PAIR = "1. 페어 매칭";
	public static final String MAIN_SEARCH_PAIR = "2. 페어 조회";
	public static final String MAIN_RESET_PAIR = "3. 페어 초기화";
	public static final String MAIN_EXIT = "Q. 종료";

	public static String requestFunction() {
		try {
			printMainScreen();
			String inputValue = Console.readLine();
			FunctionValidator.validateFunction(inputValue);
			return inputValue;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return requestFunction();
		}
	}

	private static void printMainScreen() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SELECT_FUNCTION).append("\n")
			.append(MAIN_MATCH_PAIR).append("\n")
			.append(MAIN_SEARCH_PAIR).append("\n")
			.append(MAIN_RESET_PAIR).append("\n")
			.append(MAIN_EXIT).append("\n");
		System.out.println(stringBuilder);
	}
}
