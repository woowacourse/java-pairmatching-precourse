package pairmatching.domain;

public enum Mission {
	//level 1
	GAME_RACINGCAR("자동차경주"),
	GAME_LOTTO("로또"),
	GAME_BASEBALL("숫자야구게임"),
	//level 2
	SHOPPINGBAG("장바구니"),
	PAY("결제"),
	SUBWAY_LINEMAP("지하철노선도"),
	//level 4
	IMPROVEMENT("성능개선"),
	DISTRIBUTION("배포"),
	//level 3&5
	EMPTY("");

	private String name;

	Mission(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
