package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Course getCourseByName(String courseName) {
		return getCourses().stream()
			.filter(course -> course.name.equals(courseName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("입력한 과정은 존재하지 않습니다."));
	}

	public static boolean haveName(String inputName) {
		List<String> courseNames = getCourseNames();
		return courseNames.contains(inputName);
	}

	private static List<String> getCourseNames() {
		List<String> names = new ArrayList<>();
		for (Course course : Course.values()) {
			names.add(course.name);
		}
		return names;
	}

	private static List<Course> getCourses() {
		return new ArrayList<>(Arrays.asList(Course.values()));
	}
}
