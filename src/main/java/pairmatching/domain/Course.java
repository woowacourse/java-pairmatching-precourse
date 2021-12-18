package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	Backend("backend"), FrontEnd("frontend");

	private final String course;

	Course(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public static Course getValueOf(String course) {
		return Arrays.stream(Course.values())
			.filter(x -> x.getCourse().equals(course))
			.findFirst().orElse(null);
	}
}
