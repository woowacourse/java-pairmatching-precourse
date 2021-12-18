package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchGroup {

	private Course course;
	private Level level;
	private String mission;
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

	public boolean isAlreadyMatched() {
		return (crewPairs.size() != 0);
	}

}
