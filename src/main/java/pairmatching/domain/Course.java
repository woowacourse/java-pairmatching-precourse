package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	public String getName() {
		return name;
	}

	public static Course getInstance(String name) {
		if (name.equals(Course.BACKEND.getName()))
			return Course.BACKEND;

		if (name.equals(Course.FRONTEND.getName()))
			return Course.FRONTEND;

		return null;
	}
}
