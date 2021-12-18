package pairmatching.domain;

public enum Level {
	level1("레벨1"), level2("레벨2"), level3("레벨3"), level4("레벨4"), level5("레벨5");

	private final String level;

	Level(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}
}
