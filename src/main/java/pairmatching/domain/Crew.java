package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private Course course;
	private String name;
	private List<Crew> matchedCrews = new ArrayList<>();

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public boolean hasMatchedWith(Crew crewName) {
		return matchedCrews.contains(crewName);
	}

	public void paired(Crew crewName) {
		matchedCrews.add(crewName);
	}

	@Override
	public String toString() {
		return name;
	}
}
