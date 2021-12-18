package pairmatching.domain;

import java.util.Arrays;

public enum Mission {

	CAR_RACE(Level.LEVEL1, "자동차경주"),
	LOTTO(Level.LEVEL1, "로또"),
	BASEBALL(Level.LEVEL1, "숫자야구게임"),
	BASKET(Level.LEVEL2, "장바구니"),
	PAYMENT(Level.LEVEL2, "결제"),
	SUBWAY(Level.LEVEL2, "지하철노선도"),
	TUNING(Level.LEVEL4, "성능개선"),
	DEPLOY(Level.LEVEL4, "배포");

	private final Level level;
	private final String name;

	Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public static Mission of(Level level, String name) {
		return Arrays.stream(values())
			.filter(mission -> mission.level == level)
			.filter(mission -> mission.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("미션이 존재하지 않습니다."));
	}

}
