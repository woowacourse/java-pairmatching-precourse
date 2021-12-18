package pairmatching.model;

import static pairmatching.model.Level.*;

public enum Mission {
	RACING_CAR(LEVEL1, "자동차경주"),
	LOTTO(LEVEL1, "로또"),
	BASEBALL(LEVEL1, "숫자야구게임"),
	SHOPPING_BASKET(LEVEL2, "장바구니"),
	PAYMENT(LEVEL2, "결제"),
	SUBWAY_PATH(LEVEL2, "지하철노선도"),
	IMPROVED_PERFORMANCE(LEVEL4, "성능개선"),
	DISTRIBUTION(LEVEL4, "배포");

	private final Level level;
	private final String name;

	Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}
	public Level getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public boolean isLevel(Level level) {
		return this.level == level;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}

}
