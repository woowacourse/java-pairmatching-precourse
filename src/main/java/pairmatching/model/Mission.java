package pairmatching.model;

import java.util.Arrays;

import static pairmatching.model.Error.WRONG_MISSION_NAME;

public enum Mission {
	CAR_RACING("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	CART("장바구니"),
	PAYMENT("결제"),
	SUBWAY("지하철노선도"),
	UPGRADE("성능개선"),
	RELEASE("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Mission getMissionByName(String name) {
		return Arrays.stream(Mission.values())
				.filter(mission -> mission.name.equals(name))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(WRONG_MISSION_NAME));
	}
}
