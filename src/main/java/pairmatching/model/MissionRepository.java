package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MissionRepository {
	private static final List<Mission> missions = new ArrayList<>();

	public static final List<Mission> missions() {
		return Collections.unmodifiableList(missions);
	}

	public static void addMission(Mission mission) {
		missions.add(mission);
	}

	public static List<String> findByLevel(String levelName) {
		return missions.stream()
			.filter(mission -> mission.isMissionLevelSame(levelName))
			.map(Mission::getMissionName)
			.collect(Collectors.toList());
	}
}
