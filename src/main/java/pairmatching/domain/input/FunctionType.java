package pairmatching.domain.input;

import java.util.Arrays;

public enum FunctionType {
	MATCH("1", "페어 매칭"),
	VIEW("2", "페어 조회"),
	RESET("3", "페어 초기화"),
	EXIT("Q", "종료");

	private final String functionNumber;
	private final String functionName;

	FunctionType(String functionNumber, String functionName) {
		this.functionNumber = functionNumber;
		this.functionName = functionName;
	}

	public String getFunctionNumber() {
		return functionNumber;
	}

	public static FunctionType fromFunctionNumber(String functionNumber) {
		FunctionType[] functionTypes = values();
		return Arrays.stream(functionTypes)
			.filter(functionType -> functionType.getFunctionNumber().equals(functionNumber))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 기능은 존재하지 않습니다."));
	}

	@Override
	public String toString() {
		return functionNumber + ". " + functionName;
	}
}
