package pairmatching.domain;

public class Crew {
	private Course course;
	private String name;

	public Crew(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}