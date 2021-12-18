package pairmatching.model;

import java.util.List;

public class Match {
	Course course;
	Level level;
	Mission mission;
	List<String> pair;

	public Match(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

}
