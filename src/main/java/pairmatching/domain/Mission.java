package pairmatching.domain;

import static constants.PairMatchingConstants.*;

import java.util.Arrays;

public enum Mission {
	CAR_RACING("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	SHOPPING_CART("장바구니"),
	PAYMENT("결제"),
	SUBWAY("지하철노선도"),
	PERFORMANCE_IMPROVEMENT("지하철노선도"),
	DEPLOYMENT("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public static Mission findByName(String name) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.checkName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(WRONG_MISSION_ERROR));
	}

	private boolean checkName(String name) {
		return this.name.equals(name);
	}

	@Override
	public String toString() {
		return name;
	}
}
