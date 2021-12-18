package pairmatching.domain.level;

import java.util.Arrays;

import pairmatching.exception.NoLevelException;

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

	public static Level getByName(String name) {
		return Arrays.stream(values())
			.filter(level -> level.name.equals(name))
			.findFirst()
			.orElseThrow(NoLevelException::new);
	}

	public static boolean containsName(String name) {
		return Arrays.stream(values()).anyMatch(level -> level.name.equals(name));
	}

	public String getName() {
		return name;
	}
}
