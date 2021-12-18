package pairmatching.enums;

public enum FeatureEnum {
	PAIR_MATCHING("1"),
	PAIR_SEARCH("2"),
	PAIR_INITIALIZE("3"),
	EXIT("Q");

	private final String message;

	FeatureEnum(String message) {
		this.message = message;
	}

	public boolean isSame(String feature) {
		return message.equals(feature);
	}
}
