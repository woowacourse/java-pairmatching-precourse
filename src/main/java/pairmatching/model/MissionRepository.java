package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class MissionRepository {
	private static List<Mission> missions = new ArrayList<>();

	public static void save(Mission crew) {
		missions.add(crew);
	}

	public static void saveAll(List<Mission> crewList) {
		missions.addAll(crewList);
	}

	public static List<Mission> findAll() {
		return missions;
	}
}
