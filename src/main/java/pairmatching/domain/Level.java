package pairmatching.domain;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private static final String ERROR_NO_SUCH_LEVEL = "존재하지 않는 레벨입니다.";

	private String name;

	Level(String name) {
		this.name = name;
	}

	public static Level findByName(String name) {
		return Arrays.stream(Level.values())
			.filter(level -> level.isName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NO_SUCH_LEVEL));
	}

	public String getName() {
		return name;
	}

	private boolean isName(String name) {
		return this.name.equals(name);
	}
}
