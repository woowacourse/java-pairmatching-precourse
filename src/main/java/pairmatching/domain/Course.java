package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String ERROR_OF = "해당하는 과정 이름이 없습니다.";

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course of(String str) {
		return Arrays.stream(values())
			.filter(course -> course.name.equals(str))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_OF));
	}
}
