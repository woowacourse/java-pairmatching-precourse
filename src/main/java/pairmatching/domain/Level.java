package pairmatching.domain;

import java.util.Arrays;

public enum Level {
	level1("레벨1"), level2("레벨2"), level3("레벨3"), level4("레벨4"), level5("레벨5");

	private final String level;

	Level(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public static Level getValueOf(String level) {
		return Arrays.stream(Level.values())
			.filter(x -> x.getLevel().equals(level))
			.findFirst().orElse(null);
	}
}
