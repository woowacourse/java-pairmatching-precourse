package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");
	private String name;
	Course(String name) {
		this.name = name;
	}
	public String label() {
		return name;
	}
	public static List<String> toArrayname() {
		List<String> result = new ArrayList<>();

		for (Course course: Course.values()) {
			result.add(course.label());
		}
		return result;
	}
	public static Course toEnum(String name) {
		for (Course course: Course.values()) {
			if (course.name.equals(name)) {
				return course;
			}
		}
		return null;
	}
}
