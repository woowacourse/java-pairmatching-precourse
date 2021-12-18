package pairmatching.domain;

public enum Function {
	PAIR_MATCHING("1. 페어 매칭"),
	PAIR_CHECK("2. 페어 조회"),
	PAIR_RESET("3. 페어 초기화"),
	EXIT("Q. 종료");

	private String message;

	Function(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
