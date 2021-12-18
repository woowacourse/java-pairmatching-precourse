package pairmatching.domain;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public static Crew from(Course course, String name) {
		return new Crew(course, name);
	}
}