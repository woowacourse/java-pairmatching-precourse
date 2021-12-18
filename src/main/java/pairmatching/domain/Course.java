package pairmatching.domain;

import static constants.PairMatchingConstants.*;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course findByName(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> course.checkName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(WRONG_COURSE_ERROR));
	}

	private boolean checkName(String name) {
		return this.name.equals(name);
	}

	@Override
	public String toString() {
		return name;
	}
}