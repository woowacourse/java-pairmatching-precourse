package pairmatching.model;

public class Mission {
	private Course course;
	private Level level;
	private String missionName;

	public Mission(Level level, String missionName) {
		this.level = level;
		this.missionName = missionName;
	}

	public Mission(String[] split) {
		this(Course.getCourseType(split[0]), Level.getLevelType(split[1]),
			MissionRepository.findByName(split[2]));
	}

	public Mission(Course course, Level level, String missionName) {
		this.course = course;
		this.level = level;
		this.missionName = missionName;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMissionName() {
		return missionName;
	}

	public boolean isMissionLevelSame(String levelName) {
		return level.getName().equals(levelName);
	}
}
