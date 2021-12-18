package pairmatching.domains.mission;

import static pairmatching.constant.ViewMessage.*;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;

	Level(String name) {
		this.name = name;
	}

	public static String getLevelView() {
		String form = "";
		for (Level level : Level.values()) {
			String inlineForm = LEVEL_PREFIX + level.name + LEVEL_MISSION_CONNECTOR;
			inlineForm += MissionModel.getMissionViewByLevel(level) + LINE_BREAK;
			form += inlineForm;
		}
		return form;
	}

	public String getName() {
		return name;
	}
}
