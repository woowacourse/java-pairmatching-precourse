package pairmatching.utils;

import java.util.Arrays;

public enum Function {
	PAIR_MATCHING("1"),
	PAIR_SEARCHING("2"),
	PAIR_INITIALIZING("3"),
	QUIT("Q");

	private final String functionNumber;

	Function(String functionNumber) {
		this.functionNumber = functionNumber;
	}

	public String getFunctionNumber() {
		return functionNumber;
	}

	public static Function of(String functionNumber) {
		return Arrays.stream(values())
			.filter(function -> function.getFunctionNumber().equals(functionNumber))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 기능 입니다."));
	}
}
