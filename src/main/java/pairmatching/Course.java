package pairmatching;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getName(){
		return this.name;
	}

	public static Course getCourse(String name) {
		for (Course course : Course.values()) {
			if (course.getName().equals(name)) {
				return course;
			}
		}
		throw new IllegalArgumentException("[ERROR]존재하지 않는 코스입니다.");
	}
}
