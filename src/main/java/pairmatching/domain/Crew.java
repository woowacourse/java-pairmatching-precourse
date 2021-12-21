package pairmatching.domain;

public class Crew {
	private Course course;
	private String name;

	public Crew(String name) {
		this.name = name;
	}

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean compareCourse(Course course) {
		return this.course == course;
	}

	public boolean compareCrew(String name) {
		return this.name.equals(name);
	}
}
