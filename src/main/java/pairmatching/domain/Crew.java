package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private Course course;
	private String name;
	private List<String> matchedCrews = new ArrayList<>();

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public boolean hasMatchedWith(String crewName) {
		return matchedCrews.contains(crewName);
	}

	@Override
	public String toString() {
		return name;
	}
}
