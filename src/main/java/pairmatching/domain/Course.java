package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static Course getByName(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> course.name.equals(name))
			.findFirst()
			.orElse(null);
	}
}
