package pairmatching.resource;

import java.util.Arrays;
import java.util.List;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static String getCourseOptions() {
		return String.format("과정 : %s | %s", BACKEND.name, FRONTEND.name);
	}

	public static List<String> toList(){
		return Arrays.asList("백엔드", "프론트엔드");
	}
}
