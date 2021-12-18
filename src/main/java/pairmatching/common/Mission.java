package pairmatching.common;

public enum Mission {
	RACING_CAR("자동차경주", "레벨1"),
	LOTTO("로또", "레벨1"),
	BASEBALL("숫자야구게임", "레벨1"),
	SHOPPING_BASKET("장바구니", "레벨2"),
	PAYMENT("결제", "레벨2"),
	SUBWAY_MAP("지하철노선도", "레벨2"),
	PERFORMANCE_IMPROVEMENT("성능개선", "레벨4"),
	DISTRIBUTION("배포", "레벨4");

	private String mission;
	private String level;

	Mission(String category, String description) {
		this.mission = category;
		this.level = description;
	}

	public String getMission() {
		return mission;
	}

	public String getLevel() {
		return level;
	}
}
