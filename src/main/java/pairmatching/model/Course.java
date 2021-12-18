package pairmatching.model;

import pairmatching.utils.ErrorMessageConstants;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course of(String name) {
		for (Course course : Course.values()) {
			if (course.name.equals(name)) {
				return course;
			}
		}
		throw new IllegalArgumentException(ErrorMessageConstants.NO_SUCH_COURSE_EXCEPTION);
	}

	public String getName() {
		return this.name;
	}
}
