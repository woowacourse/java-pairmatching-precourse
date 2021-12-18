package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
	CAR_RACE("자동차 경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL("숫자야구게임", Level.LEVEL1),
	CART("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY("지하철노선도", Level.LEVEL2),
	REFACTOR("성능개선", Level.LEVEL4),
	RELEASE("배포", Level.LEVEL4);

	private static final String ERROR_NO_SUCH_MISSION = "존재하지 않는 미션입니다.";

	private String name;
	private Level level;

	Mission(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public static Mission findByName(String name) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.isName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NO_SUCH_MISSION));
	}

	public boolean isLevel(Level level) {
		return this.level == level;
	}

	private boolean isName(String name) {
		return this.name.equals(name);
	}
}
