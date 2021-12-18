package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionRepository {
	private static List<Mission> missions = new ArrayList<>();

	public static void save(Mission mission) {
		missions.add(mission);
	}

	public static void saveAll(List<Mission> missionList) {
		missions.addAll(missionList);
	}

	public static List<Mission> findAll() {
		return missions;
	}

	public static boolean existsByName(String name) {
		return missions.stream().anyMatch(m -> m.getName().equals(name));
	}

	public static Mission findByName(String name) {
		return missions.stream().filter(m -> m.getName().equals(name)).findFirst().get();
	}

	public static List<Mission> findByLevel(Level level) {
		return missions.stream().filter(m -> m.getLevel().equals(level)).collect(Collectors.toList());
	}
}
