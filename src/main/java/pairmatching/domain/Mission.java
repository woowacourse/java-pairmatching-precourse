package pairmatching.domain;

import java.util.List;

public class Mission {
	private Course course;
	private Level level;
	private String name;

	public Mission(Course course, Level level, String name) {
		this.course = course;
		this.level = level;
		this.name = name;
	}

	public boolean isMatchMission(List<String> missionInput) {
		return course.toString().equals(missionInput.get(0))
			&& level.toString().equals(missionInput.get(1))
			&& name.equals(missionInput.get(2));
	}
}
