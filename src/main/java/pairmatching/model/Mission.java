package pairmatching.model;

import java.util.Objects;

public class Mission {
	private Level level;
	private String name;

	public Mission(Level level, String missionName) {
		this.name = missionName;
		this.level = level;
	}

	public boolean isSameLevel(Level level) {
		return Objects.equals(this.level, level);
	}

	public Level getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}
}


