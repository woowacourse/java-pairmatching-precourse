package pairmatching.domain;

import java.util.Arrays;

import pairmatching.util.ErrorMessage;

public enum ContinuePairMatching {
	YES("네"),
	NO("아니오");

	private String function;

	ContinuePairMatching(String function) {
		this.function = function;
	}

	public static ContinuePairMatching fromString(String text) {
		contains(text);
		return Arrays.stream(ContinuePairMatching.values())
			.filter(e -> e.getFunction().equals(text))
			.findAny()
			.get();
	}

	public static void contains(String text) {
		if (Arrays.stream(ContinuePairMatching.values())
			.noneMatch(e -> e.getFunction().equals(text))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_CONTINUE_PAIR_MATCHING_NONE);
		}
	}

	public String getFunction() {
		return function;
	}
}
