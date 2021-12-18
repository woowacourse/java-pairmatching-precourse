package pairmatching.model;

import java.util.List;

public class Levels {
	private List<Level> levels;

	public List<Level> getLevels() {
		return levels;
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
}
