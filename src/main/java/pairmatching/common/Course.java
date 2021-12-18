package pairmatching.common;

public enum Course {
	BACKEND("백엔드", "src/main/resources/backend-crew.md"),
	FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

	private final String course;
	private final String path;

	Course(String information, String path) {
		this.course = information;
		this.path = path;
	}

	public String getCourse() {
		return course;
	}

	public String getPath() {
		return path;
	}
}

