package pairmatching.domain.crew;

import pairmatching.domain.input.Course;

public class Crew {
	private Course course;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	private String name;

}
