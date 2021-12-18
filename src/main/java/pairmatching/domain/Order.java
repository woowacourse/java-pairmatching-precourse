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

	public boolean isMatching() {
		return this.name.equals("1");
	}

	public boolean isSearch() {
		return this.name.equals("2");
	}

	public boolean isInit() {
		return this.name.equals("3");
	}

	public boolean isFinish() {
		return this.name.equals("Q");
	}
}
