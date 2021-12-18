package pairmatching.domain.input;

public enum Function {
	MATCH("1", "페어 매칭"),
	VIEW("2", "페어 조회"),
	RESET("3", "페어 초기화"),
	EXIT("Q", "종료");

	private final String functionNumber;
	private final String functionName;

	Function(String functionNumber, String functionName) {
		this.functionNumber = functionNumber;
		this.functionName = functionName;
	}

	@Override

	public String toString() {
		return functionNumber + ". " + functionName;
	}
}
