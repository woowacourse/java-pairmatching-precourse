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

	public static boolean isExit(String name) {
		return name.equals(EXIT.getName());
	}

	public static boolean isMatch(String name) {
		return name.equals(MATCH.getName());
	}

	public static boolean isLook(String name) {
		return name.equals(LOOK.getName());
	}

	public static boolean isInit(String name) {
		return name.equals(INIT.getName());
	}

	public static boolean isCorrectFunction(String function) {
		return 1 == Arrays.stream(Function.values()).filter(
			f -> f.getName().equals(function)
		).count();
	}
}
