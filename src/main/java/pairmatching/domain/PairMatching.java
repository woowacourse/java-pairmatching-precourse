package pairmatching.domain;

import java.util.List;

public class PairMatching {
	private final Course course;
	private final Level level;
	private final Mission mission;
	private List<Crew> matchCrews;

	public PairMatching(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}
}
