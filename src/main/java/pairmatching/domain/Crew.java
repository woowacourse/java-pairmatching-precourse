package pairmatching.domain;

public class Crew {
	private Course course;
	private String name;

	private Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public static Crew generateCrew(Course course, String name) {
		return new Crew(course, name);
	}
}
