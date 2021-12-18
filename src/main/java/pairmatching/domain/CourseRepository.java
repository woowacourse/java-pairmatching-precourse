package pairmatching.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class CourseRepository {
	public static EnumMap<Course, EnumMap<Level, List<Mission>>> courseMap = new EnumMap<>(Course.class);

	static {
		Arrays.stream(Course.values()).forEach(course -> {
			EnumMap<Level, List<Mission>> levelMap = new EnumMap<>(Level.class);
			Arrays.stream(Level.values()).forEach(level -> levelMap.put(level, level.missions()));
			courseMap.put(course, levelMap);
		});
	}

	public static boolean isExistPairMatching(String courseName, String levelName, String missionName) {
		Mission mission = findMission(courseName, levelName, missionName);
		return mission.isExistPairMatching();
	}

	public static Mission findMission(String courseName, String levelName, String missionName) {
		Course course = Course.from(courseName);
		Level level = Level.from(levelName);
		return courseMap.get(course).get(level).stream()
			.filter(m -> m.equals(Mission.from(missionName)))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
	}

	public static List<Mission> findMissions(String courseName, String levelName) {
		Course course = Course.from(courseName);
		Level level = Level.from(levelName);
		return courseMap.get(course).get(level);
	}

	public static void resetPairOfMission(String courseName, String levelName, Mission mission) {
		Course course = Course.from(courseName);
		Level level = Level.from(levelName);
		courseMap.get(course).get(level).stream()
			.filter(m -> m.equals(mission))
			.forEach(Mission::resetCrewPairs);
	}

	public static void setCrewPairToMission(String courseName, String levelName, Mission mission,
		List<CrewPair> crewPairs) {
		Course course = Course.from(courseName);
		Level level = Level.from(levelName);
		courseMap.get(course).get(level).stream()
			.filter(m -> m.equals(mission))
			.forEach(m -> m.setCrewPairs(crewPairs));
	}

	public static List<CrewPair> makePair(String courseName, String levelName, String missionName) {
		Mission mission = findMission(courseName, levelName, missionName);
		resetPairOfMission(courseName, levelName, mission);
		List<Mission> missions = findMissions(courseName, levelName);
		for (int i = 0; i < 3; i++) {
			List<CrewPair> crewPairs = PairMaker.makeBackendCrewPair(missions);
			if (!crewPairs.isEmpty()) {
				setCrewPairToMission(courseName, levelName, mission, crewPairs);
				return crewPairs;
			}
		}
		throw new IllegalArgumentException("매칭에 실패했습니다.");
	}

	public static List<String> getMatchingList(String courseName, String levelName, String missionName) {
		Mission mission = findMission(courseName, levelName, missionName);
		return mission.getCrewPairNameList();
	}
}
