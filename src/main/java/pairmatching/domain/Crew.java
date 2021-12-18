package pairmatching.domain;

import pairmatching.enums.Course;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}
}
