package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course find(String name) {
		for (Course course : values()) {
			if (course.name.equals(name)) {
				return course;
			}
		}
		return null;
	}

	public static boolean contains(String name) {
		for (Course course : values()) {
			if (course.name.equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}
}
