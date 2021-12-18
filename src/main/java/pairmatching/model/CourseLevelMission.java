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
		this.level = Level.parse(courseLevelMissionList.get(1));
		this.mission = Mission.parse(this.level, courseLevelMissionList.get(2));

		return this;
	}
}
