package pairmatching.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static String getLevelInfo() {
		List<Level> levelList = levelList();
		List<String> levelInfoList = levelList.stream().map(Level::toString).collect(Collectors.toList());
		return String.format(ProgramData.MISSION_INFO_MESSAGE,
			String.join(ProgramData.NEWLINE_SEPARATOR, levelInfoList));
	}

	@Override
	public String toString() {
		String missionInfo = String.join(ProgramData.BAR_SEPARATOR, missionList);
		return String.format(ProgramData.LEVEL_INFO_FORMAT, name, missionInfo);
	}

	public String getName() {
		return name;
	}

	public static Level selectLevel(String name) {
		List<Level> levelList = levelList();
		for(Level level:levelList) {
			if(level.getName().equals(name)) {
				return level;
			}
		}
		return null;
	}

	public boolean checkMission(String mission) {
		return missionList.contains(mission);
	}
}