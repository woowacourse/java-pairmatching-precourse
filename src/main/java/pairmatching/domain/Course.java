package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String name;

	Course(String name) {
		this.name = name;
	}

	public static Course findByName(String name) {
		return Arrays.stream(Course.values())
			.filter(e -> e.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당하는 과정이 없습니다."));
	}
}
