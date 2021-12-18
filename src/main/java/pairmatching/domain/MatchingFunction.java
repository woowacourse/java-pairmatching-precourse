package pairmatching.domain;

import java.util.Arrays;

import pairmatching.util.ErrorMessage;

public enum MatchingFunction {
	MATCHING("1"),
	LOOKUP("2"),
	INITIALIZATION("3"),
	QUIT("Q");

	private String function;

	MatchingFunction(String function) {
		this.function = function;
	}

	public static MatchingFunction fromString(String text) {
		contains(text);
		return Arrays.stream(MatchingFunction.values())
			.filter(e -> e.getFunction().equals(text))
			.findAny()
			.get();
	}

	public static void contains(String text) {
		if (Arrays.stream(MatchingFunction.values())
			.noneMatch(e -> e.getFunction().equals(text))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_FUNCTION_NONE);
		}
	}

	public String getFunction() {
		return function;
	}
}
