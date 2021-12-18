package pairmatching.domain;

import java.util.List;

import pairmatching.util.ErrorMessage;

public class PairMatching {
	private final Course course;
	private final Level level;
	private final Mission mission;
	private List<List<Crew>> matchCrews;

	public PairMatching(Course course, Level level, Mission mission) {
		validate(level, mission);
		
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

	public Mission getMission() {
		return mission;
	}

	public void validate(Level level, Mission mission) {
		LevelGroup levelGroup = LevelGroup.findGroup(level.getName());
		if (!LevelGroup.hasMission(levelGroup, mission)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_LEVEL_MISSION_NONE_MATCH);
		}
	}
}
