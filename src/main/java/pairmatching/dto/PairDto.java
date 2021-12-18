package pairmatching.dto;

public class PairDto {
	private static final String PAIR_COMPOSITION_SPLIT = ", ";
	private final String input;

	public PairDto(String input) {
		this.input = input;
	}

	public void toPair() {
		String[] pair = input.split(PAIR_COMPOSITION_SPLIT);
	}
}
