package pairmatching.model;

import java.util.Arrays;

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

	public static Course getCourseType(String courseName) {
		courseName = replaceGap(courseName);
		System.out.println(courseName);
		String finalCourseName = courseName;
		return Arrays.stream(values())
			.filter(course -> course.getName().equals(finalCourseName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 코스는 없습니다."));
	}

	protected static String replaceGap(String name) {
		name = name.replace(" ", "");
		return name;
	}
}
