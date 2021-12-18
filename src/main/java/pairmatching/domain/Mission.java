package pairmatching.domain;

public class Mission {
	private Level level;
	private String name;

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Level getLevel() {
		return level;
	}
}
