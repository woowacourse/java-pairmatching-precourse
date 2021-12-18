package pairmatching.enums;

import static pairmatching.enums.ErrorMessage.*;

import java.util.List;

import pairmatching.domain.MissionList;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private static final String SEPARATOR = " | ";

	private String name;

	Level(String name) {
		this.name = name;
	}

	public static Level getByValue(String level) {
		for (Level value : Level.values()) {
			if (value.getName().equals(level)) {
				return value;
			}
		}
		throw new IllegalArgumentException(LEVEL_GET_BY_VALUE_ERROR.get());
	}

	public String getName() {
		return name;
	}

	public String getMissionsJoinBar() {
		MissionList missionList = new MissionList();
		List<String> missions = missionList.getMission().get(this);
		return String.join(SEPARATOR, missions);
	}
}
