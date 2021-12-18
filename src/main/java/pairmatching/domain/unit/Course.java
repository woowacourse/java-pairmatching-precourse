package pairmatching.domain.unit;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course mapToCourse(String courseName) {
		return Arrays.stream(Course.values())
			.filter(course ->  course.name.equals(courseName))
			.findFirst().get();
	}

	public String getName() {
		return getName();
	}

	// 추가 기능 구현
}