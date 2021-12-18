package pairmatching.model;

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

	public String getName() {
		return name;
	}

	public Level getLevel() {
		return level;
	}
}
