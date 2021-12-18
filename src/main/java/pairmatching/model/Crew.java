package pairmatching.model;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public boolean sameCourse(String course) {
		return this.course.getName().equals(course);
	}

	public String getName() {
		return name;
	}
}
