package pairmatching.domain;

public enum Level {
	level1(1), level2(2), level3(3), level4(4), level5(5);

	private final int level;

	Level(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
