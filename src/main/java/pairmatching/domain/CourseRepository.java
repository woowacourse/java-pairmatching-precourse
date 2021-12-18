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
		Course course = Course.from(courseName);
		Level level = Level.from(levelName);
		Mission mission = courseMap.get(course).get(level).stream()
			.filter(m -> m.equals(Mission.from(missionName)))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
		return mission.isExistPairMatching();
	}
}
