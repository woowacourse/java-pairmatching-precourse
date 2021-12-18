package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String name;

	Course(String name) {
		this.name = name;
	}

	public static Course of(String name) {
		return Arrays.stream(values())
			.filter(course -> course.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("과정이 존재하지 않습니다."));
	}

}
