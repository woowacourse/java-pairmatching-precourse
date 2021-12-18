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
		return name;
	}

	public static Course of(String courseName) {
		return Arrays.stream(values())
			.filter(course -> course.getName().equals(courseName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 코스 입니다."));
	}
}
