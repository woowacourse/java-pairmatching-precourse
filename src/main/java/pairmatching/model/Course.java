package pairmatching.model;

import java.util.Arrays;

import pairmatching.exception.CourseException;

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

	public boolean isSameName(String name){
		return this.name.equals(name);
	}

	public static Course findCourseByName(String courseName) {
		return Arrays.stream(Course.values()).filter(
			course -> course.getName().equals(courseName)
		).findFirst().orElseThrow(CourseException::new);
	}
}
