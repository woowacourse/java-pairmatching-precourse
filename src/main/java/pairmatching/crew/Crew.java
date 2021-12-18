package pairmatching.crew;

import pairmatching.Course;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public boolean isBackend() {
		return course == Course.BACKEND;
	}

	public boolean isFrontend() {
		return course == Course.FRONTEND;
	}

	public String toString() {
		return name;
	}
}
