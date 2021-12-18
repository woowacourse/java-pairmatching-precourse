package pairmatching.controller;

public enum Option {
	MATCH_PAIRS("1"), PRINT_MATCHED_PAIRS("2"), INITIALIZE_PAIRS("3"), QUIT("Q");

	private String symbol;

	Option(String symbol) {
		this.symbol = symbol;
	}

	public static Option valueBySymbol(String symbol) {
		if (symbol.equals("1")) {
			return MATCH_PAIRS;
		} else if (symbol.equals("2")) {
			return PRINT_MATCHED_PAIRS;
		} else if (symbol.equals("3")) {
			return INITIALIZE_PAIRS;
		}
		return QUIT;
	}
}
