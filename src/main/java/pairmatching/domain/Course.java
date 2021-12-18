package pairmatching.domain;

import static pairmatching.Constant.*;

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
		return String.join(DELIMITER, names);
	}

	public static boolean isContains(String str) {
		return Arrays.stream(values())
			.map(f -> f.name)
			.anyMatch(k -> k.equals(str));
	}

	public static Course byName(String name) {
		return Arrays.stream(values())
			.filter(f -> f.name.equals(name))
			.findFirst()
			.orElse(null);
	}
}
