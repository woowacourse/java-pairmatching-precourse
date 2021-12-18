package pairmatching.domain;

import java.util.Arrays;

import pairmatching.util.ErrorMessage;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private final String name;

	Level(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Level fromString(String text) {
		isExists(text);
		return Arrays.stream(Level.values())
			.filter(e -> e.getName().equals(text))
			.findAny()
			.get();
	}

	public static void isExists(String text) {
		if (Arrays.stream(Level.values())
			.noneMatch(e -> e.getName().equals(text))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_LEVEL_NONE);
		}
	}
}
