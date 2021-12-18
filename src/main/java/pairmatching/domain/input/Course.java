package pairmatching.domain.input;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	public String getName() {return name;}

	Course(String name) {
		this.name = name;
	}

	public static Course fromCourseName(String courseName) {
		Course[] courses = values();
		return Arrays.stream(courses)
			.filter(functionType -> functionType.getName().equals(courseName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 코스는 존재하지 않습니다."));
	}
}