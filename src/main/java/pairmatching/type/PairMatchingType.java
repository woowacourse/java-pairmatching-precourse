package pairmatching.type;

public enum PairMatchingType {
	MATCH(1),
	VIEW(2),
	RESET(3),
	QUIT("Q");

	private int number;
	private String string;

	PairMatchingType(int number) {
		this.number = number;
	}

	PairMatchingType(String string) {
		this.string = string;
	}

	public int getNumber() {
		return this.number;
	}

	public String getString() {
		return this.string;
	}
}
