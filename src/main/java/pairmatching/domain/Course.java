package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}


	public static Course getCourse(String name) {
		return Arrays.stream(Course.values())
				.filter(course -> course.name.equals(name))
				.findAny()
				.get();
	}

	public String getName() {
		return name;
	}

	// 추가 기능 구현
}
