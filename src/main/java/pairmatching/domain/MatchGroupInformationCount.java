package pairmatching.domain;

public enum MatchGroupInformationCount {

	COUNT(3);

	private final int number;

	MatchGroupInformationCount(int number) {
		this.number = number;
	}

	public static boolean isCountNotEquals(int number) {
		return COUNT.number != number;
	}

}
