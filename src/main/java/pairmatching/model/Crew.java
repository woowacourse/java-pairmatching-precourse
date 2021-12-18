package pairmatching.model;

import java.util.HashMap;
import java.util.Map;

public class Crew {
	private Course course;
	private String name;
	private Map<Crew, Level> history = new HashMap<>();

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}
}
