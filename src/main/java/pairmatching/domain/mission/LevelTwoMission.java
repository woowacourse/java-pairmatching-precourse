package pairmatching.domain.mission;

public enum LevelTwoMission implements Mission {
	CART("장바구니"),
	PAYMENT("결제"),
	SUBWAY_MAP("지하철노선도");

	private String name;

	LevelTwoMission(String name) {
		this.name = name;
	}
}
