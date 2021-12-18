package pairmatching.model;

import java.util.List;
import java.util.Map;

public class Crew {
	private Course course;
	private String name;
	private MatchedCrew matchedCrew;

	public String getName() {
		return name;
	}

	public void initCrew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public void addMatchedCrew(Level level, Crew crew) throws IllegalArgumentException {
		matchedCrew.add(level, crew);
	}
}
