package pairmatching.resource;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static String getCourseOptions() {
		return String.format("과정 : %s | %s", BACKEND.name, FRONTEND.name);
	}
}
