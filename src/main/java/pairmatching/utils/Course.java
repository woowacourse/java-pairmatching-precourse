package pairmatching.utils;

import java.util.HashSet;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String course;

	Course(String name) {
		this.course = name;
	}

	public static HashSet<String> generateAllCourses() {
		HashSet<String> allCourses = new HashSet<>();
		for (Course eachCourse : Course.values()) {
			allCourses.add(eachCourse.getCourse());
		}
		return allCourses;
	}

	public String getCourse() {
		return this.course;
	}
}