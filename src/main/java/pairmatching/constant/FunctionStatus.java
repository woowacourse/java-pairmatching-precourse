package pairmatching.constant;

public enum FunctionStatus {
	PAIR_MATCHING,
	PAIR_SEARCH,
	PAIR_CLEAR,
	EXIT,
	INVALID_INPUT;

	public FunctionStatus getByString(String input) {
		if (input==("1")) {
			return  PAIR_MATCHING;
		}
		if (input==("2")) {
			return PAIR_SEARCH;
		}
		if (input.equals("3")) {
			return PAIR_CLEAR;
		}
		if (input.equals("Q")) {
			return EXIT;
		}
		return INVALID_INPUT;
	}
}
