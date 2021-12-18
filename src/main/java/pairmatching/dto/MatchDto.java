package pairmatching.dto;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class MatchDto {

	private Course course;
	private Level level;
	private String missionName;

	public MatchDto(String courseName, String levelName, String missionName) {
		this.course = Course.of(courseName);
		this.level = Level.of(levelName, missionName);
		this.missionName = missionName;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMissionName() {
		return this.missionName;
	}

}
