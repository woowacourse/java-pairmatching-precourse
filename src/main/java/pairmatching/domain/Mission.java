package pairmatching.domain;

public enum Mission {
	CAR_RACING(Level.LEVEL1, "자동차경주"),
	LOTTO(Level.LEVEL1, "로또"),
	NUMBER_BASEBALL_GAME(Level.LEVEL1, "숫자야구게임"),
	SHOPPING_BASKET(Level.LEVEL2, "장바구니"),
	PAYMENT(Level.LEVEL2, "결제"),
	SUBWAY_MAP(Level.LEVEL2, "지하철노선도"),
	IMPROVEMENT_OF_PERFORMANCE(Level.LEVEL4, "성능개선"),
	DEPLOYMENT(Level.LEVEL4, "배포");

	private final Level level;
	private final String title;

	Mission(Level level, String title) {
		this.level = level;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
