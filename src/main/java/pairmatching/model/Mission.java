package pairmatching.model;

public class Mission {
	private Level level;
	private String name;

	public Mission(Level level, String missionName) {
		this.name = missionName;
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}
}


