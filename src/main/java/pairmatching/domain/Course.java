package pairmatching.domain;

import java.util.stream.Stream;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String ERROR_MESSAGE_NO_COURSE = "해당 코스가 없습니다.";
	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course from(String course) {
		return Stream.of(Course.values())
			.filter(name -> name.getName().equals(course))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NO_COURSE));
	}

	public String getName() {
		return name;
	}
}