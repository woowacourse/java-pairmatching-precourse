package pairmatching.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crew {
	private Course course;
	private String name;
	private Map<Level, List<Crew>> history = new HashMap<>();

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

	public boolean haveWeMet(Level level, Crew crew) {
		return history.get(level).contains(crew);
	}
}
