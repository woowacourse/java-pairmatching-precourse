package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String ERROR_NO_SUCH_COURSE = "존재하지 않는 과정입니다.";

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course findByName(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> course.isName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NO_SUCH_COURSE));
	}

	public String getName() {
		return name;
	}

	private boolean isName(String name) {
		return this.name.equals(name);
	}
}
