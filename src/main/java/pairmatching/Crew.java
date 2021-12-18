package pairmatching;

public class Crew {
	private Course course;
	private String name;

	public Crew(String name, Course course) {
		this.name = name;
		this.course = course;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Course getCourse() {
		return course;
	}
}
