package pairmatching.constant;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.StringJoiner;

public enum Level {
	LEVEL1("레벨1", "자동차경주", "로또", "숫자야구게임"),
	LEVEL2("레벨2", "장바구니", "결제", "지하철노선도"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4", "성능개선", "배포"),
	LEVEL5("레벨5");

	private String name;
	private String[] missionNames;

	Level(String name, String... missionNames) {
		this.name = name;
		this.missionNames = missionNames;
	}

	public String getName() {
		return name;
	}

	public static String getSelfDescription() {
		StringBuffer stringBuffer = new StringBuffer();
		for (Level level : Level.values()) {
			stringBuffer.append("  - ");
			stringBuffer.append(level.name);
			stringBuffer.append(": ");
			String missionNames = joinStringMissionNames(level);
			stringBuffer.append(missionNames);
			stringBuffer.append(NEWLINE);
		}
		return stringBuffer.toString();
	}

	private static String joinStringMissionNames(Level level) {
		StringJoiner joiner = new StringJoiner(" | ");
		for (String missionName : level.missionNames) {
			joiner.add(missionName);
		}
		return joiner.toString();
	}
}
