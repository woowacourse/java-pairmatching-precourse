package pairmatching.common;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String course;

	Course(String information) {
		this.course = information;
	}

	public String getCourse() {
		return course;
	}
}

