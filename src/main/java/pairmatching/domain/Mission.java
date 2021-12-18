package pairmatching.domain;

public class Mission {
	private Level level;
	private String name;

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public boolean isSame(String level, String name) {
		return this.level.isSame(level) && this.name.equals(name);
	}
}
