package pairmatching.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LevelMissionsMap {

	private HashMap<Level, List<Mission>> levelMissions = new HashMap<>();

	public LevelMissionsMap(HashMap<Level, List<Mission>> levelMissions) {
		this.levelMissions = levelMissions;
	}

	public String missionsToString(Level level) {
		List<Mission> missions = levelMissions.get(level);
		return missions.stream()
				.map(mission -> mission.getName())
				.collect(Collectors.joining(" | "));
	}

	public boolean isMissionInLevel(Level level, Mission inputMission) {
		List<Mission> missions = levelMissions.get(level);
		return missions.contains(inputMission);
	}
}