package pairmatching.domain;

public enum Mission {
	CAR_RACE("자동차 경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL("숫자야구게임", Level.LEVEL1),
	CART("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY("지하철노선도", Level.LEVEL2),
	REFACTOR("성능개선", Level.LEVEL4),
	RELEASE("배포", Level.LEVEL4);

	private String name;
	private Level level;

	Mission(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public boolean isLevel(Level level) {
		return this.level == level;
	}
}
