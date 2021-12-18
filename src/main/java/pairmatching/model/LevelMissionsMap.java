package pairmatching.model;

import java.util.HashMap;
import java.util.List;

public class LevelMissionsMap {

	private HashMap<Level, List<Mission>> levelMissions = new HashMap<>();

	public LevelMissionsMap(HashMap<Level, List<Mission>> levelMissions) {
		this.levelMissions = levelMissions;
	}
}
