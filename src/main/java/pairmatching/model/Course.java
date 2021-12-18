package pairmatching.model;

import java.util.Arrays;
import java.util.stream.Collectors;

import pairmatching.validator.CourseValidator;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static String getAllCourse() {
		return Arrays.stream(values()).map(it -> it.name).collect(Collectors.joining(" | "));
	}

	public static Course parse(String name) {
		return Arrays.stream(values())
			.filter(course -> name.equals(course.name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(CourseValidator.ERROR_NOT_EXISTED));
	}
}
