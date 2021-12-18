package pairmatching.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.repository.CourseRepository;
import pairmatching.repository.MissionRepository;

public class Initializer {
	public static void init() {
		initCourse();
		initMission();
	}

	private static void initCourse() {
		List<Course> courses = new ArrayList<>();
		for (Course course : Course.values()) {
			courses.add(course);
		}
		CourseRepository.setCourses(courses);
	}

	private static void initMission() {
		LinkedHashMap<Level, List<String>> mission = new LinkedHashMap<>();
		mission.put(Level.LEVEL1, Arrays.asList("자동차경주", "로또", "숫자야구게임"));
		mission.put(Level.LEVEL2, Arrays.asList("장바구니", "결제", "지하철노선도"));
		mission.put(Level.LEVEL3, Arrays.asList());
		mission.put(Level.LEVEL4, Arrays.asList("성능 개선", "배포"));
		mission.put(Level.LEVEL5, Arrays.asList());
		MissionRepository.setMission(mission);
	}
}
