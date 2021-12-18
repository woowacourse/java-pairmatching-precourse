package pairmatching.dto;

import pairmatching.domain.Pair;

public class PairDto {
	private static final String PAIR_COMPOSITION_SPLIT = ", ";
	private final String input;

	public PairDto(String input) {
		this.input = input;
	}

	public Pair toPair() {
		String[] pairs = input.split(PAIR_COMPOSITION_SPLIT);
		return Pair.of(pairs[0], pairs[1], pairs[2]);
	}
}
