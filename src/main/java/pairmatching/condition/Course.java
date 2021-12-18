package pairmatching.condition;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String ERROR_NOT_FOUND = "해당 과정은 존재하지 않습니다.";

	private String name;

	Course(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static Course validateChoose(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> course.name.equals(name))
			.findFirst()
			.orElseThrow(() ->
				new IllegalArgumentException(ERROR_NOT_FOUND));
	}
}
