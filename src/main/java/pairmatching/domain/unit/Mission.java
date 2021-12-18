package pairmatching.domain.unit;

import java.util.Arrays;

public enum Mission {

	CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	BASKET("장바구니"),
	PAY("결제"),
	SUBWAY("지하철노선도"),
	UPGRADE("성능개선"),
	DISTRIBUTE("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public static Mission mapToLevel(String name) {
		return Arrays.stream(Mission.values())
			.filter(mission ->  mission.name() == name)
			.findFirst().get();
	}

	public String getName() {
		return name;
	}
}
