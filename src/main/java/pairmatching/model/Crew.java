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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Crew, Level> getHistory() {
		return history;
	}

	public void setHistory(Map<Crew, Level> history) {
		this.history = history;
	}
}
