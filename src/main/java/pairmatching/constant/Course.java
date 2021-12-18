package pairmatching.constant;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.Arrays;
import java.util.StringJoiner;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course of(String name) {
		return Arrays.stream(Course.values())
			.filter(course -> course.name.equals(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE));
	}

	public static String getSelfDescription() {
		StringJoiner joiner = new StringJoiner(" | ");
		for (Course course : Course.values()) {
			joiner.add(course.name);
		}
		return joiner.toString();
	}
}
