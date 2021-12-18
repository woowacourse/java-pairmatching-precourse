package pairmatching.type;

import java.util.Arrays;
import java.util.List;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;
	private List<String> missionList;

	Level(String name) {
		this.name = name;
	}

	public void setMissionList(List<String> missionList) {
		this.missionList = missionList;
	}

	public static List<Level> levelList() {
		List<Level> levelList = Arrays.asList(Level.values());
		return levelList;
	}
}