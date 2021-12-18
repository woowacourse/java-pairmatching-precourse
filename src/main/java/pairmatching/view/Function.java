package pairmatching.view;

public enum Function {
	PAIR_MATCHING('1', "페어 매칭"),
	PAIR_INQUIRY('2', "페어 조회"),
	PAIR_INITIALIZATION('3', "페어 초기화"),
	TERMINATION('Q', "종료");

	private final char key;
	private final String message;

	Function(char key, String message) {
		this.key = key;
		this.message = message;
	}

	@Override
	public String toString() {
		return key + ". " + message;
	}
}
