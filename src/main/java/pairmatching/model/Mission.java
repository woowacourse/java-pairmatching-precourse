package pairmatching.model;

public class Mission {
	private Level level;
	private String missionName;

	public Mission(Level level, String missionName) {
		this.level = level;
		this.missionName = missionName;
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
