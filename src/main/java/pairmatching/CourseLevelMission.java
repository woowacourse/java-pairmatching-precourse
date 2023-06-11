package pairmatching;

public class CourseLevelMission {
	Course course;
	Level level;
	String mission;

	public CourseLevelMission (Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public boolean isEquals(CourseLevelMission courseLevelMission) {
		return course.equals(courseLevelMission.course) && level.equals(courseLevelMission.level) && mission.equals(courseLevelMission.mission);
	}
}
