package pairmatching.domain;

import static pairmatching.Constants.*;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;

	Level(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	public static Level findByName(String input) {
		exceptionNotContain(input);
		return Arrays.stream(Level.values()).filter(level -> level.name.equals(input)).findFirst().get();
	}

	private static void exceptionNotContain(String input) {
		if (!Arrays.stream(Level.values()).anyMatch(level -> level.name.equals(input))) {
			throw new IllegalArgumentException(NO_EXIST_LEVEL);
		}
	}
}
