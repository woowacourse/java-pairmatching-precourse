package pairmatching.domain;

public enum Mission {
	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	SHOPPING_BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_PATH("지하철노선도"),
	PERFORMANCE("성능개선"),
	DEPLOYMENT("배포");


	private String name;

	Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Mission getInstance(String name) {
		if (name.equals(Mission.RACING_CAR.getName()))
			return Mission.RACING_CAR;
		if (name.equals(Mission.LOTTO.getName()))
			return Mission.LOTTO;
		if (name.equals(Mission.BASEBALL.getName()))
			return Mission.BASEBALL;
		if (name.equals(Mission.SHOPPING_BASKET.getName()))
			return Mission.SHOPPING_BASKET;
		if (name.equals(Mission.PAYMENT.getName()))
			return Mission.PAYMENT;
		if (name.equals(Mission.SUBWAY_PATH.getName()))
			return Mission.SUBWAY_PATH;
		if (name.equals(Mission.PERFORMANCE.getName()))
			return Mission.PERFORMANCE;
		if (name.equals(Mission.DEPLOYMENT.getName()))
			return Mission.DEPLOYMENT;

		return null;
	}
}
