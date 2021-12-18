package pairmatching.constant;

public enum Mission {
	RACING("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	BUCKET("장바구니"),
	BUY("결제"),
	SUBWAY("지하철노선도"),
	OPTIMIZING("성능개선"),
	DEPLOYMENT("배포");

	private final String name;

	Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Mission nameOf(String name) {
		for (Mission mission : Mission.values()) {
			if (mission.name.equals(name)) {
				return mission;
			}
		}
		return null;
	}
}
