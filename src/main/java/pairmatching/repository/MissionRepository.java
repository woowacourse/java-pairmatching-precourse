package pairmatching.repository;

import java.util.LinkedHashMap;
import java.util.List;

import pairmatching.domain.Level;

public class MissionRepository {
	public static LinkedHashMap<Level, List<String>> missions;

	public static void setMissions(LinkedHashMap<Level, List<String>> missions) {
		MissionRepository.missions = missions;
	}

	public static List<String> getMissionByLevel(Level level) {
		return missions.get(level);
	}

	public static boolean existLevel(String level) {
		return missions.keySet().contains(Level.nameToLevel(level));
	}

	public static boolean existMission(String level, String mission) {
		List<String> missionsByLevel = MissionRepository.missions.get(Level.nameToLevel(level));
		return missionsByLevel.contains(mission);
	}
}
