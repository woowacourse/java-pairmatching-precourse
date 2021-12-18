package pairmatching.model;

import java.util.Arrays;

public enum Function {
	매칭("1"),
	조회("2"),
	초기화("3"),
	종료("Q");

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
