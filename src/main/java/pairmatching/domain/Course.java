package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.CourseNotFoundException;

public enum Course {

	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course of(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> name.equals(course.name))
			.findAny()
			.orElseThrow(CourseNotFoundException::new);
	}

	public String getName() {
		return this.name;
	}

}
