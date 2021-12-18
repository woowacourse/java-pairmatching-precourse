package pairmatching.domain;

public class Crew {
	private String course;
	private String name;

	public Crew(String course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
