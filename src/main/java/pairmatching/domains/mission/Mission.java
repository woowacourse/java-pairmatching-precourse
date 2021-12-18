package pairmatching.domains.mission;

import static pairmatching.domains.mission.Level.*;

public enum Mission {
	RACING_CAR(LEVEL1, "자동차경주"),
	LOTTO(LEVEL1, "로또"),
	NUMBER_BASEBALL(LEVEL1, "숫자야구게임"),
	CART(LEVEL2, "장바구니"),
	PAY(LEVEL2, "결제"),
	SUBWAY(LEVEL2, "지하철노선도"),
	PERFORMANCE(LEVEL4, "성능개선"),
	DEPLOY(LEVEL4, "배포");

	private Level level;
	private String korean;

	Mission(Level level, String korean) {
		this.level = level;
		this.korean = korean;
	}

}
