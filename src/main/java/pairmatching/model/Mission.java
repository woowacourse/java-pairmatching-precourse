package pairmatching.model;

import java.util.Objects;

public class Mission {
	private Level level;
	private String name;

	private Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public static Mission of(Level level, String name) {
		return new Mission(level, name);
	}

	@Override
	public String toString() {
		return "Mission{" +
			"level=" + level +
			", name='" + name + '\'' +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Mission mission = (Mission) o;
		return level == mission.level && Objects.equals(name, mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(level, name);
	}

	public String getName() {
		return name;
	}

	public Level getLevel() {
		return level;
	}
}
