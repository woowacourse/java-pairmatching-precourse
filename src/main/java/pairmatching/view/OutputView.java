package pairmatching.view;

import java.util.List;

public class OutputView {

	private static final String SELECT_FUNCTION = "기능을 선택하세요.";
	private static final String ERROR_HEADER = "[ERROR] ";

	private OutputView() {
	}

	public static void printError(IllegalArgumentException IAE) {
		printNewLine();
		System.out.println(ERROR_HEADER + IAE.getMessage());
	}

	public static void askFunction(List<String> functions) {
		printNewLine();
		System.out.println(SELECT_FUNCTION);
		functions.forEach(System.out::println);
	}

	private static void printNewLine() {
		System.out.println();
	}
}
