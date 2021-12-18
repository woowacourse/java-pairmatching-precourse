package pairmatching.domain;

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

	public static Course fromString(String text) {
		for (Course course : Course.values()) {
			if (course.name.equals(text)) {
				return course;
			}
		}
		return null;
	}
}
