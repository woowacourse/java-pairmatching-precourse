package pairmatching.domain.crew;

import pairmatching.domain.Course;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}
}
