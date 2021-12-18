package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

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

	public boolean isValidMission(String missionString) {
		return levels.stream()
			.anyMatch(level -> level.getMissions().stream()
				.anyMatch(mission -> mission.getName().equals(missionString))
			);
	}

	public String toStringLevels() {
		List<String> levelsString = levels.stream()
			.map(Level::toString)
			.collect(Collectors.toList());
		return String.join("\n", levelsString);
	}

}
