package pairmatching.constant;

import java.util.StringJoiner;

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

	public static String getSelfDescription() {
		StringJoiner joiner = new StringJoiner( " | ");
		for (Course course : Course.values()) {
			joiner.add(course.name);
		}
		return joiner.toString();
	}
}
