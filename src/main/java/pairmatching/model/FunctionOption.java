package pairmatching.model;

import java.util.Arrays;
import java.util.Objects;

import pairmatching.exception.NotFoundFunctionOptionException;

public enum FunctionOption {
	MATCH("1"),
	READ("2"),
	RESET("3"),
	EXIT("Q");

	private final String functionOption;

	FunctionOption(String functionOption) {
		this.functionOption = functionOption;
	}

	public static FunctionOption of(String request) {
		return Arrays.stream(FunctionOption.values())
			.filter(functionOption -> Objects.equals(functionOption.functionOption, request))
			.findFirst()
			.orElseThrow(() -> new NotFoundFunctionOptionException());
	}
}
