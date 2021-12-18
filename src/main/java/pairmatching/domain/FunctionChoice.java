package pairmatching.domain;

import java.util.Arrays;

import pairmatching.exception.FunctionChoiceNotFoundException;

public enum FunctionChoice {

	PAIR_MATCH("1", "페어 매칭"),
	PAIR_SEARCH("2", "페어 조회"),
	PAIR_RESET("3", "페어 초기화"),
	PAIR_QUIT("Q", "종료");

	private final String choice;
	private final String value;

	FunctionChoice(String choice, String value) {
		this.choice = choice;
		this.value = value;
	}

	public static FunctionChoice of(String choice) {
		return Arrays.stream(FunctionChoice.values())
			.filter(functionChoice -> choice.equals(functionChoice.choice))
			.findAny()
			.orElseThrow(FunctionChoiceNotFoundException::new);
	}


	@Override
	public String toString() {
		return choice + ". " + value;
	}

}
