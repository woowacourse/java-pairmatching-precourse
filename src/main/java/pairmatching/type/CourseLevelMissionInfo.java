package pairmatching.type;


public class CourseLevelMissionInfo {
	public Course course;
	public Level level;
	public String mission;

	public CourseLevelMissionInfo(String[] info) {
		course = Course.selectCourse(info[0]);
		level = Level.selectLevel(info[1]);
		mission = info[2];
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
