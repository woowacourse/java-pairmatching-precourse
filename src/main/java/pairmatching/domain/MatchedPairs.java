package pairmatching.domain;

import java.util.List;

public class MatchedPairs {
	private List<Pair> pairs;
	private Course course;
	private Mission mission;
	private Level level;

	public MatchedPairs(List<Pair> pairs, Course course, Level level, Mission mission) {
		this.pairs = pairs;
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public boolean isCourse(Course course) {
		return this.course == course;
	}

	public boolean isLevel(Level level) {
		return this.level == level;
	}

	public boolean isMission(Mission mission) {
		return this.mission == mission;
	}

	public Level getLevel() {
		return level;
	}
}
