package pairmatching.model;

public class Crew {

	private Course course;
	private String name;
	private String pair;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
