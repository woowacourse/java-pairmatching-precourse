package pairmatching.model;

public enum Role {
	PAIR_MATCH("1", "페어 매칭"),
	PAIR_INQUIRE("2", "페어 조회"),
	PAIR_INITIALIZE("3", "페어 초기화"),
	EXIT("Q", "종료");

	private String number;
	private String name;

	Role(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public String toString() {
		return number + ". " + name;
	}
}
