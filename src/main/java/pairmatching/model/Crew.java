package pairmatching.model;

import java.util.List;
import java.util.Map;

public class Crew {
	private Course course;
	private String name;
	private MatchedCrew matchedCrew;

	public void initCrew(Course course, String name) {
		this.course = course;
		this.name = name;
	}
}
