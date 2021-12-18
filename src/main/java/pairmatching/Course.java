package pairmatching;

import java.util.List;

public enum Course {
	BACKEND("백엔드"), FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getCourse() {
		return name;

	}

	public static List<String> crewLoad(Course course) {
		if (course.equals(BACKEND.getCourse())) {
			return FileReading.backCrewReading();		}
		return FileReading.frontCrewReading();

	}

}
