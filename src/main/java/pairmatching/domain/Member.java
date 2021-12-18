package pairmatching.domain;

public class Member {
	private String name;
	private Course Course;

	public Member(String name, Course course) {
		this.name = name;
		Course = course;
	}

	public String getName() {
		return name;
	}

	public pairmatching.domain.Course getCourse() {
		return Course;
	}
}
