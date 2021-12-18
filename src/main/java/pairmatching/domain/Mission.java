package pairmatching.domain;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Mission mission = (Mission)o;
		return Objects.equals(name, mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
