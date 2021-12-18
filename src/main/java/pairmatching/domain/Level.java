package pairmatching.domain;

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
		for (Level level : Level.values()) {
			if (level.name.equals(text)) {
				return level;
			}
		}
		return null;
	}
}
