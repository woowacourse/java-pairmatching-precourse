package pairmatching.constant;

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

	public static Course ofName(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> course.getName().equals(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_COURSE));
	}
}