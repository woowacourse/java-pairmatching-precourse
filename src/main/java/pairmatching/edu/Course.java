package pairmatching.edu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static List<String> toStrings() {
		return Arrays.stream(Course.values())
			.map(Course::getName)
			.collect(Collectors.toList());
	}

	public static String toStringAllNameSplit(String spliter) {
		return String.join(spliter, toStrings());
	}

	public static Course findByName(String name) {
		return Arrays.stream(Course.values())
			.filter(n -> n.getName().equals(name))
			.collect(Collectors.toList())
			.get(0);
	}

	// 추가 기능 구현
}
