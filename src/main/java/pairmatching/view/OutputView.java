package pairmatching.view;

import java.util.Arrays;

import pairmatching.domain.Function;

public class OutputView {

	private static final String FUNCTION_SELECT_MESSAGE = "기능을 선택하세요.";

	public void printFunctionList() {
		System.out.println(FUNCTION_SELECT_MESSAGE);
		Arrays.stream(Function.values())
			.forEach(function -> System.out.println(function.getMessage()));
	}
}
