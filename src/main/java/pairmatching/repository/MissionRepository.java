package pairmatching.repository;

import java.util.LinkedHashMap;
import java.util.List;

import pairmatching.domain.Level;

public class MissionRepository {
	public static LinkedHashMap<Level, List<String>> mission;

	public static void setMission(LinkedHashMap<Level, List<String>> mission) {
		MissionRepository.mission = mission;
	}

	public static List<String> getMissionByLevel(Level level) {
		return mission.get(level);
	}
}
