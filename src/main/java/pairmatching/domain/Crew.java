package pairmatching.domain;

public class Crew {
	private final Course course;
	private final String name;

	private Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public static Crew of(Course course, String name) {
		return new Crew(course, name);
	}

	public String getName() {
		return name;
	}
}
