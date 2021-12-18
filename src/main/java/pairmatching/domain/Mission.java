package pairmatching.domain;

public enum Mission {
	RACING("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	CART("장바구니"),
	PAYMENT("결제"),
	SUBWAY("지하철노선도"),
	IMPROVEMENT("성능개선"),
	DEPLOY("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public static Mission nameOf(String missionName) {
		for (Mission mission : Mission.values()) {
			if (mission.getName().equals(missionName)) {
				return mission;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}
}
