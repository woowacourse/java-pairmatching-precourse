package pairmatching.model;

public class Crew {
	private String name;
	private Course course;

	private Crew(String name, Course course) {
		this.name = name;
		this.course = course;
	}

	public static Crew of(String name, Course course) {
		return new Crew(name, course);
	}

	@Override
	public String toString() {
		return "Crew{" +
			"name='" + name + '\'' +
			", course=" + course +
			'}';
	}

	public String getName() {
		return name;
	}

	public Course getCourse() {
		return course;
	}
}
