package pairmatching.domain.course;

import java.util.Arrays;

import pairmatching.exception.NoCourseException;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course getByName(String name) {
		return Arrays.stream(values())
			.filter(course -> course.name.equals(name))
			.findFirst()
			.orElseThrow(NoCourseException::new);
	}

	public static boolean containsName(String name) {
		return Arrays.stream(values()).anyMatch(course -> course.name.equals(name));
	}

	public String getName() {
		return name;
	}
}
