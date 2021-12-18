package pairmatching.domain;

import java.util.Arrays;

import pairmatching.util.ErrorMessage;

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

	public static Course fromString(String text) {
		isExists(text);
		return Arrays.stream(Course.values())
			.filter(e -> e.getName().equals(text))
			.findAny()
			.get();
	}

	public static void isExists(String text) {
		if (Arrays.stream(Course.values())
			.noneMatch(e -> e.getName().equals(text))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_COURSE_NONE);
		}
	}
}
