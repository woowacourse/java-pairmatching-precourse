package pairmatching.domain;

public class Mission {
	private Level level;
	private String name;

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public Boolean isLevel(Level level) {
		return this.level == level;
	}

	public String getName() {
		return name;
	}
}
