package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String toString() {
		return name + " " + course;
	}

}
