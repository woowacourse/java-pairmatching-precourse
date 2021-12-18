package pairmatching.Model;

import java.util.Arrays;

import pairmatching.Model.menu.MainMenu;
import pairmatching.util.ErrorMessage;
import pairmatching.util.Symbol;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}
	public static void fineCourse(String courseName) {
		Arrays.stream(Course.values())
			.filter(c ->c.name.equals(courseName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COURSE_NAME.getMessage()+ Symbol.NEW_LINE));
	}
	public static String getCourseInfo(){
		return String.format("과정: %s | %s", BACKEND.name, FRONTEND.name);
	}
}
