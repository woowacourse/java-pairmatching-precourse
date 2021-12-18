package pairmatching.model;

import java.util.List;

public class Levels {
	private List<Level> levels;

	public Levels(List<Level> levels) {
		this.levels = levels;
	}

	public boolean isValidLevel(String levelString) {
		return levels.stream()
			.map(Level::getName)
			.anyMatch(level -> level.equals(levelString));
	}
}
