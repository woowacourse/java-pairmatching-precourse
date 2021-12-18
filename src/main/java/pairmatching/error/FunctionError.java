package pairmatching.error;

public enum FunctionError {
	NOT_PROPER_VALUE("1, 2, 3 또는 Q를 입력해주세요.");

	private String error;

	FunctionError(String error) {
		this.error = error;
	}

	public String getError() {
		return this.error;
	}
}
