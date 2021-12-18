package pairmatching.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Crew {
	private Course course;
	private String name;
	private List<List<String>> pairRecord ;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
		this.pairRecord = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void savePairRecord(Level level, Crew crew) {
		pairRecord.get(level.getNumber()).add(crew.getName());
	}

	public boolean hasRecord(Level level, String crewName) {
		if (pairRecord.get(level.getNumber()).size() == 0) {
			return true;
		}
		return !pairRecord.get(level.getNumber()).contains(crewName);
	}
}
