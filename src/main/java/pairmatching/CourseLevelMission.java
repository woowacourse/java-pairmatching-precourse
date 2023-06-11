package pairmatching;

import java.util.List;
import java.util.Objects;

public class CourseLevelMission {
	Course course;
	Level level;
	String mission;

	public CourseLevelMission (Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}
	public String toString() {
		return course.label() + ":" +level.label() + ":" + mission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CourseLevelMission)) {
			return false;
		}
		CourseLevelMission courseLevelMission = (CourseLevelMission) o;
		return course.equals(courseLevelMission.course) && level.equals(courseLevelMission.level) && mission.equals(courseLevelMission.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mission);
	}

}
