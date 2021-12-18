package pairmatching.domain;

public class Pair {
	private final Course course;
	private final Level level;
	private final Mission mission;

	private Pair(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public static Pair of(String courseTitle, String levelTitle, String missionTitle) {
		Course course = Course.getByTitle(courseTitle);
		Level level = Level.getByTitle(levelTitle);
		Mission mission = Mission.getByTitleAndLevel(level, missionTitle);
		return new Pair(course, level, mission);
	}
}
