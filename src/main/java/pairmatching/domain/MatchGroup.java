package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.view.input.Delimiter;

public class MatchGroup {

	private final Course course;
	private final Level level;
	private final String mission;
	private List<List<Crew>> crewPairs = new ArrayList<>();

	public MatchGroup(Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public boolean isEquals(Course course, Level level, String mission) {
		return this.course.isEquals(course)
			&& this.level.isEquals(level)
			&& mission.equals(this.mission);
	}

	public void updateCrewPair(List<List<Crew>> crewPairs) {
		this.crewPairs = crewPairs;
	}

	public boolean isAlreadyMatched() {
		return (crewPairs.size() != 0);
	}

	public List<String> getPairResultsAsString() {
		List<String> results = new ArrayList<>();
		crewPairs.forEach((List<Crew> crewPair) -> {
			results.add(Delimiter.joinWithColon(crewPair.stream().map(Crew::getName).collect(Collectors.toList())));
		});
		return results;
	}

}
