package pairmatching.domain;

import java.util.Arrays;

public enum Order {

	MATCHING("1"),
	SEARCH("2"),
	INIT("3"),
	KILL("Q");

	private final String name;

	Order(String name) {
		this.name = name;
	}

	public static Order of(String name) {
		return Arrays.stream(values())
			.filter(order -> order.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("기능을 찾을 수 없습니다."));
	}
}
