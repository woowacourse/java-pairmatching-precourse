package pairmatching.view;

import java.util.stream.Stream;

import pairmatching.Function;

public class OutputView {
	private static final String MAIN_TITLE = "기능을 선택하세요.";

	private static final String OPTION_FORMAT = "%s. %s%n";
	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	public void printMain() {
		System.out.println(MAIN_TITLE);
		Stream.of(Function.values())
			.forEach(
				function -> System.out.printf(OPTION_FORMAT, function.getCode(), function.getName()));
	}

	public void printError(Exception exception) {
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}
}
