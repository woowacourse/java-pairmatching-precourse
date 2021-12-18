package pairmatching.model;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public static Course getCourseByString(String courseString) {
		if (courseString.equals("백엔드")) {
			return BACKEND;
		}
		if (courseString.equals("프론트엔드")) {
			return FRONTEND;
		}
		return null;
	}
}
