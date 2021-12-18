package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public static Course nameOf(String courseName) {
		for (Course course : Course.values()) {
			if (course.getName().equals(courseName)) {
				return course;
			}
		}
		return null;
	}

	private String getName() {
		return name;
	}
}
