package pairmatching.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.repository.CourseRepository;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;

public class Initializer {
	public static void init() {
		initCourse();
		initMission();
		initCrew();
	}

	private static void initCrew() {
		initBackCrew();
		initFrontCrew();
	}

	private static void initFrontCrew() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("frontend-crew.md");
		String text = new BufferedReader(
			new InputStreamReader(inputStream, StandardCharsets.UTF_8))
			.lines()
			.collect(Collectors.joining("\n"));
		StringTokenizer stringTokenizer = new StringTokenizer(text, "\n");
		List<Crew> frontCrews = new ArrayList<>();
		while (stringTokenizer.hasMoreTokens()) {
			frontCrews.add(new Crew(Course.FRONTEND, stringTokenizer.nextToken()));
		}
		CrewRepository.setFrontCrew(frontCrews);
	}

	private static void initBackCrew() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("backend-crew.md");
		String text = new BufferedReader(
			new InputStreamReader(inputStream, StandardCharsets.UTF_8))
			.lines()
			.collect(Collectors.joining("\n"));
		StringTokenizer stringTokenizer = new StringTokenizer(text, "\n");
		List<Crew> backCrews = new ArrayList<>();
		while (stringTokenizer.hasMoreTokens()) {
			backCrews.add(new Crew(Course.BACKEND, stringTokenizer.nextToken()));
		}
		CrewRepository.setBackCrew(backCrews);
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
		MissionRepository.setMissions(mission);
	}
}
