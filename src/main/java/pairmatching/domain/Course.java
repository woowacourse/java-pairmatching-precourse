package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public static List<String> getCourseList(){
		return Stream.of(Course.values()).map(s -> s.getName()).collect(Collectors.toList());
	}
	public static String toOutputString(){
		StringBuilder sb = new StringBuilder();
		sb.append("과정 : ")
			.append(String.join(" | ", getCourseList()))
			.append("\n");
		return sb.toString();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("과정 : ")
			.append(Course.values().toString().join(" | "))
			.append("\n");
		return sb.toString();
	}
}
