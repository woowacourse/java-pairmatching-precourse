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

	public static Mission findByNameAndCourse(String name, Course course) {
		return missions.stream()
			.filter(m -> m.getName().equals(name))
			.filter(m -> m.getCourse().equals(course))
			.findFirst().get();
	}

	public static List<Mission> findByLevelAndCourse(Level level, Course course) {
		return missions.stream()
			.filter(m -> m.getLevel().equals(level))
			.filter(m -> m.getCourse().equals(course))
			.collect(Collectors.toList());
	}

	public static List<String> findDistinctMissionNames() {
		return findAllByCourse(Course.BACKEND).stream().map(Mission::getName).collect(Collectors.toList());
	}

	public static List<Mission> findAllByCourse(Course course) {
		return missions.stream()
			.filter(m -> m.getCourse().equals(course))
			.collect(Collectors.toList());
	}
}
