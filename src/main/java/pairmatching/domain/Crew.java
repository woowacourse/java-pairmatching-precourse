package pairmatching.domain;

public class Crew {

	private final Course course;
	private final String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public boolean isCourseEquals(Course course) {
		return (this.course == course);
	}

	public String getName() {
		return this.name;
	}

}
