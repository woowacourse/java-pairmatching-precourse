package pairmatching.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	public String getName() {
		return name;
	}

	public static Course ofName(String name) {
		List<Course> courses = Arrays.stream(Course.values())
			.filter(course -> course.getName().equals(name))
			.collect(Collectors.toList());
		return courses.get(0);
	}
}