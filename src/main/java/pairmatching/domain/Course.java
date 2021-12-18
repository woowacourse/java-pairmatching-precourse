package pairmatching.domain;

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

	// 추가 기능 구현
	public static Course mappingStringValue(String courseName) {
		return Arrays.stream(Course.values())
			.filter(course -> course.getName().equals(courseName))
			.findFirst()
			.orElseThrow( () -> new IllegalArgumentException("[ERROR] 과정을 잘 못 입력하셨습니다."));
	}
}
