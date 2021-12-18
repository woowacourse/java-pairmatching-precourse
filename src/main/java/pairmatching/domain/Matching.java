package pairmatching.domain;

public class Matching {
	private final Course course;
	private final Level level;
	private final MissionType missionType;
	private final Pairs pairs;

	public Matching(Course course, Level level, MissionType missionType, Pairs pairs) {
		this.course = course;
		this.level = level;
		this.missionType = missionType;
		this.pairs = pairs;
	}


	public boolean equalsCourse(Course course) {
		return course.equals(course);
	}

	public boolean equalsLevel(Level level) {
		return level.equals(level);
	}
}
