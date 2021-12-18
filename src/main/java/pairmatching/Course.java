package pairmatching;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;
	private static final Course[] COURSESLIST = Course.values();

	Course(String name) {
		this.name = name;
	}

	public static Course[] getCoursesList() {
		return COURSESLIST;
	}

	public String getName() {
		return name;
	}

}
