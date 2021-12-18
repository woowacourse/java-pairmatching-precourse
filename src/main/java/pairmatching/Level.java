package pairmatching;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private static final String ERROR_NOT_FOUND = "해당 레벨은 존재하지 않습니다.";

	private String name;

	Level(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static Level validateChoose(String name) {
		return Arrays.stream(Level.values())
			.filter(level -> level.name.equals(name))
			.findFirst()
			.orElseThrow(() ->
				new IllegalArgumentException(ERROR_NOT_FOUND));
	}
}
