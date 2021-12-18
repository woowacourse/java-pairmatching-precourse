package pairmatching.domain;

import java.util.Arrays;

import pairmatching.constant.Notification;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String title;

	Course(String title) {
		this.title = title;
	}

	public static Course getByTitle(String courseTitle) {
		return Arrays.stream(values())
			.filter(course -> course.title.equals(courseTitle))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Notification.NOT_SUPPORTED_COURSE.getMessage()));
	}

	public String getTitle() {
		return this.title;
	}

	public boolean isFrontEnd() {
		return this == Course.FRONTEND;
	}

	public boolean isBackEnd() {
		return this == Course.BACKEND;
	}
}
