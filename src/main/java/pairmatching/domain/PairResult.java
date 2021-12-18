package pairmatching.domain;

import java.util.List;

public class PairResult {
	private Course course;
	private Level level;
	private String mission;
	private List<String> pairs;

	public PairResult(Course course, Level level, String mission, List<String> pairs) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.pairs = pairs;
	}
}
