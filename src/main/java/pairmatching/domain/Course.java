package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	Backend("백엔드"), FrontEnd("프론트엔드");

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
