package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String name;

	Course(String name) {
		this.name = name;
	}

	public static String listAsString() {
		String[] names = Arrays.stream(values())
			.map(c -> c.name)
			.toArray(String[]::new);
		return String.join(" | ", names);
	}
}
