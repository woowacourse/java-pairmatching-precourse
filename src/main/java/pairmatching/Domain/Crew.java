package pairmatching.Domain;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private Course course;
	private String name;
	private List<List<String>> pairRecord = new ArrayList<>();

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void savePairRecord(Level level, Crew crew) {
		pairRecord.get(level.getNumber()).add(crew.getName());
	}

	public boolean hasRecord(Level level, String crewName) {
		return !pairRecord.get(level.getNumber()).contains(crewName);
	}
}
