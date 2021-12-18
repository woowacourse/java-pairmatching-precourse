package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
	RACING("자동차경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL("숫자야구게임", Level.LEVEL1),
	SHOPPING("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY("지하철노선도", Level.LEVEL2),
	PERFORMANCE("성능개선", Level.LEVEL4),
	DEPLOY("배포", Level.LEVEL4);

	private String name;
	private Level level;

	Mission(String missionName, Level level) {
		this.name = missionName;
		this.level = level;
	}

	public static Mission findByName(String input) {
		exceptionNotContain(input);
		return Arrays.stream(Mission.values()).filter(mission -> mission.name.equals(input)).findFirst().get();
	}

	private static void exceptionNotContain(String input) {
		if (!Arrays.stream(Mission.values()).anyMatch(mission -> mission.name.equals(input))) {
			throw new IllegalArgumentException("존재하지 않는 과정입니다.");
		}
	}
}
