package pairmatching.model;

import java.util.Arrays;

public enum Mission {
	CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	IMPROVE("성능개선"),
	BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY("지하철노선도"),
	DISTRIBUTE("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isSameName(String name){
		return this.name.equals(name);
	}

	public static Mission findMissionByName(String missionName) {
		return Arrays.stream(Mission.values()).filter(
			mission -> mission.getName().equals(missionName)
		).findFirst().orElseThrow(()-> new IllegalArgumentException("미션이 존재하지 않습니다."));
	}
}
