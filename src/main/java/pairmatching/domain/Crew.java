package pairmatching.domain;

public class Crew {
	private Course course;
	private String name;

	private Crew(String name, Course course) {
		this.name = name;
		this.course = course;
	}

	public static Crew of(String name, Course course) {
		return new Crew(name, course);
	}

	public Course getCourse() {
		return this.course;
	}

	@Override
	public String toString() {
		return name;
	}
}
