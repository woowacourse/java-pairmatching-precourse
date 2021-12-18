package pairmatching.domain;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class Crew {
	private Course course;
	private String name;
	private PairHistory pairHistory;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
		this.pairHistory = new PairHistory();
	}

	public String getName() {
		return name;
	}

	public void addHistory(Level level, String opponent) {
		pairHistory.add(level, opponent);
	}

	public boolean didMeet(Level level, String opponent) {
		return pairHistory.didMeet(level,opponent);
	}
}
