package pairmatching.domain;

import pairmatching.exception.NotFoundCourseException;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String INFO = "과정: 백엔드 | 프론트엔드";
	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course getCourse(String name) {
		if ("백엔드".equals(name)) {
			return BACKEND;
		}
		if ("프론트엔드".equals(name)) {
			return FRONTEND;
		}
		throw new NotFoundCourseException();
	}

	@Override
	public String toString() {
		return INFO;
	}
}