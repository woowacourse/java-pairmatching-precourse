package pairmatching.constant;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.Arrays;
import java.util.StringJoiner;

public enum LevelAndMission {
	LEVEL1("레벨1", "자동차경주", "로또", "숫자야구게임"),
	LEVEL2("레벨2", "장바구니", "결제", "지하철노선도"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4", "성능개선", "배포"),
	LEVEL5("레벨5");

	private String levelName;
	private String[] missionNames;

	public static boolean isExistLevelAndMissions(String levelName, String missionName) {
		return Arrays.stream(LevelAndMission.values())
			.filter(e -> e.levelName.equals(levelName))
			.anyMatch(e -> Arrays.stream(e.missionNames)
				.anyMatch(e2 -> e2.equals(missionName))
			);
	}

	LevelAndMission(String levelName, String... missionNames) {
		this.levelName = levelName;
		this.missionNames = missionNames;
	}

	public String getLevelName() {
		return levelName;
	}

	public static String getSelfDescription() {
		StringBuffer stringBuffer = new StringBuffer();
		for (LevelAndMission levelAndMission : LevelAndMission.values()) {
			stringBuffer.append("  - ");
			stringBuffer.append(levelAndMission.levelName);
			stringBuffer.append(": ");
			String missionNames = joinStringMissionNames(levelAndMission);
			stringBuffer.append(missionNames);
			stringBuffer.append(NEWLINE);
		}
		return stringBuffer.toString();
	}

	private static String joinStringMissionNames(LevelAndMission levelAndMission) {
		StringJoiner joiner = new StringJoiner(" | ");
		for (String missionName : levelAndMission.missionNames) {
			joiner.add(missionName);
		}
		return joiner.toString();
	}
}
