package pairmatching.model;

import java.util.Arrays;

public enum Function {
	MATCH("1"),
	LOOK("2"),
	INIT("3"),
	EXIT("Q");

	private String name;

	Function(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static boolean isCorrectFunction(String function) {
		return 1 == Arrays.stream(Function.values()).filter(
			f -> f.getName().equals(function)
		).count();
	}
}
