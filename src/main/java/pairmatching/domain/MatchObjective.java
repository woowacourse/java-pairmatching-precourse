package pairmatching.domain;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class MatchObjective {
	private Course course;
	private Level level;
	private String mission;

	public MatchObjective(Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}
}
