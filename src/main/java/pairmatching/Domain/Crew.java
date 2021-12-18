package pairmatching.Domain;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
