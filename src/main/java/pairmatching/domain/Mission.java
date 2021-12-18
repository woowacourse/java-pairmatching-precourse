package pairmatching.domain;

public enum Mission {
	CARRACE("자동차경주"),
	LOTTO("로또"),
	BASEBALLGAME("숫자야구게임"),
	SHOPPING("장바구니"),
	SUBWAY("지하철노선도"),
	IMPROVEMENT("성능개선"),
	DEPLOYMENT("배포"),
	CREDIT("결제");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public static Mission find(String name) {
		for (Mission mission : values()) {
			if (mission.name.equals(name)) {
				return mission;
			}
		}
		return null;
	}

	public static boolean contains(String name) {
		for (Mission mission : values()) {
			if (mission.name.equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}
}
