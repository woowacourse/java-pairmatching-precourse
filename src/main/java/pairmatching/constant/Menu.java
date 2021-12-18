package pairmatching.constant;

public enum Menu {
	MATCHING("1", "페어 매칭"),
	READ("2", "페어 조회"),
	RESET("3", "페어 초기화"),
	QUIT("Q", "종료");

	private String functionNumber;
	private String functionName;

	Menu(String functionNumber, String functionName) {
		this.functionNumber = functionNumber;
		this.functionName = functionName;
	}

	public String getFunctionNumber() {
		return functionNumber;
	}

	public String getFunctionName() {
		return functionName;
	}
}
