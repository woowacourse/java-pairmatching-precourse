package pairmatching.domain.matching;

import java.util.List;

import pairmatching.domain.input.Course;
import pairmatching.domain.input.Level;

public class Matching {
	private Course course;
	private Level level;
	private String missionName;
	private List<Pair> matchedPairs;

	public Matching(Course course, Level level, String missionName,
		List<Pair> matchedPairs) {
		this.course = course;
		this.level = level;
		this.missionName = missionName;
		this.matchedPairs = matchedPairs;
	}
}
