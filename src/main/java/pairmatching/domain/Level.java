package pairmatching.domain;

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

	public static Level getLevel(String name) {
		return Arrays.stream(Level.values())
				.filter(level -> level.name.equals(name))
				.findAny()
				.get();
	}

	public String getName() {
		return name;
	}
}
