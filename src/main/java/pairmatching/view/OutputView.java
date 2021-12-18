package pairmatching.view;

import java.util.List;

public class OutputView {

	private static final String SELECT_FUNCTION = "기능을 선택하세요.";

	private OutputView() {
	}

	public static void askFunction(List<String> functions) {
		System.out.println(SELECT_FUNCTION);
		functions.forEach(System.out::println);
	}
}
