package pairmatching.domain;

import java.util.Arrays;

public enum Function {
	PAIR_MATCHING("1", "1. 페어 매칭"),
	PAIR_CHECK("2", "2. 페어 조회"),
	PAIR_RESET("3", "3. 페어 초기화"),
	EXIT("Q", "Q. 종료");

	private String number;
	private String message;

	Function(String number, String message) {
		this.number = number;
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public static  boolean isValidNumber(String number) {
		return Arrays.stream(Function.values())
			.filter(function -> function.number.equals(number))
			.findFirst()
			.isPresent();
	}

	public static Function getByNumber(String number) {
		return Arrays.stream(Function.values())
			.filter(function -> function.number.equals(number))
			.findFirst()
			.get();
	}
}
