package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseLevelMission {
	Course course;
	Level level;
	Mission mission;

	public CourseLevelMission init(String courseLevelMission) {
		List<String> courseLevelMissionList = Arrays.stream(courseLevelMission.split(", ")).collect(Collectors.toList());
		this.course = Course.parse(courseLevelMissionList.get(0));
		this.level = course.getLevel(courseLevelMissionList.get(1));
		this.mission = level.getMission(courseLevelMissionList.get(2));

		return this;
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
}
