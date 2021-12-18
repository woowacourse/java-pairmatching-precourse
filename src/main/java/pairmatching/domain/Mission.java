package pairmatching.domain;

public enum Mission {
	RACING_CAR("자동차경주"),
	LOTTERY("로또"),
	NUMBER_BASEBALL_GAME("숫자야구게임"),
	SHOPPING_BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_MAP("자하철노선도"),
	IMPROVED_PERFORMANCE("성능 개선"),
	DISTRIBUTE("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}
}
