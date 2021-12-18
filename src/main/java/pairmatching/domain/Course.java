package pairmatching.domain;

import java.util.Arrays;

import pairmatching.view.ErrorMessage;

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

	public static Course getCourse(String name) {
		return Arrays.stream(values())
			.filter(course -> course.getName().equals(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COURSE_NAME));
	}

	public static boolean isExistingCourse(String inputCourse) {
		return Arrays.stream(values())
			.map(Course::getName)
			.anyMatch(name -> name.equals(inputCourse));
	}
}
