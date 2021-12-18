package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	NUMBER_BASEBALL("숫자야구게임"),
	SHOP_BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_MAP("지하철노선도"),
	PERFORMANCE_IMPROVEMENT("성능개선"),
	DEPLOYMENT("배포");

	private static final String ERROR = "미션을 잘못 입력하셨습니다.";

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public static Mission of(String str) {
		return Arrays.stream(values())
			.filter(mission -> mission.name.equals(str))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR));
	}
}
