package pairmatching.type;

public enum Mission {
	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	BASKET("장바구니"),
	PURCHASE("결제"),
	SUBWAY("지하철노선도"),
	IMPROVEMENT("성능개선"),
	DISTRIBUTE("배포");

	private String mission;

	Mission(String mission) {
		this.mission = mission;
	}

	public String getMission() {
		return this.mission;
	}
}
