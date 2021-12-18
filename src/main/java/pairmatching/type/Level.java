package pairmatching.type;

import java.util.Arrays;
import java.util.List;

import pairmatching.data.ProgramData;

public enum Level {
	LEVEL1("레벨1", ProgramData.LEVEL1_MISSION),
	LEVEL2("레벨2", ProgramData.LEVEL2_MISSION),
	LEVEL3("레벨3", ProgramData.LEVEL3_MISSION),
	LEVEL4("레벨4", ProgramData.LEVEL4_MISSION),
	LEVEL5("레벨5", ProgramData.LEVEL5_MISSION);

	private String name;
	private List<String> missionList;

	Level(String name, List<String> missionList) {
		this.name = name;
		this.missionList = missionList;
	}

	public static List<Level> levelList() {
		List<Level> levelList = Arrays.asList(Level.values());
		return levelList;
	}
}