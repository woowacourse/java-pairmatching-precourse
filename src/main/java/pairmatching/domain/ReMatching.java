package pairmatching.domain;

import java.util.Arrays;

public enum ReMatching {
	YES("네"),
	NO("아니오");

	private final String value;

	ReMatching(String value) {
		this.value = value;
	}

	public static ReMatching of(String value) {
		return Arrays.stream(values())
			.filter(reMatching -> reMatching.value.equals(value))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("다시 입력해주세요."));
	}

	public boolean isNoWantReMatch() {
		return this.value.equals("아니오");
	}

}
