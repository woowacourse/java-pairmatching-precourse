package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course findByName(String input) {
		exceptionNotContain(input);
		return Arrays.stream(Course.values()).filter(course -> course.name.equals(input)).findFirst().get();
	}

	private static void exceptionNotContain(String input) {
		if (!Arrays.stream(Course.values()).anyMatch(course -> course.name.equals(input))) {
			throw new IllegalArgumentException("존재하지 않는 과정입니다.");
		}
	}
}
