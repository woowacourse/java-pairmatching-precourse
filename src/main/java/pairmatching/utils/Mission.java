package pairmatching.utils;

public enum Mission {
	자동차경주(1), 로또(1), 숫자야구게임(1),
	장바구니(2), 결제(2), 지하철노선도(2),
	성능개선(4), 배포(4);

	private final int level;

	Mission(int level) {
		this.level = level;
	}

	public boolean equalLevel(int level) {
		return this.level == level;
	}

	public String getName() {
		return this.name();
	}
}
