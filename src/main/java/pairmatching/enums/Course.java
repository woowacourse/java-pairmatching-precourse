package pairmatching.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String SEPARATOR = " | ";

	private String name;

	Course(String name) {
		this.name = name;
	}

	public String get() {
		return name;
	}

	public static String getNamesJoinBar() {
		return Arrays.stream(Course.values())
			.map(Course::get)
			.collect(Collectors.joining(SEPARATOR));
	}
}
