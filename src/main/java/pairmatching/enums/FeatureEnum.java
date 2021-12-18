package pairmatching.enums;

import static pairmatching.enums.ErrorMessage.*;

import java.util.Arrays;

public enum FeatureEnum {
	PAIR_MATCHING("1"),
	PAIR_SEARCH("2"),
	PAIR_INITIALIZE("3"),
	EXIT("Q");

	private final String message;

	FeatureEnum(String message) {
		this.message = message;
	}

	public static void validateDomain(String feature) {
		if (Arrays.stream(FeatureEnum.values())
			.anyMatch(featureEnum -> featureEnum.message.equals(feature))) {
			return;
		}
		throw new IllegalArgumentException(INPUT_EXECUTE_FEATURE_ERROR.get());
	}

	public boolean isSame(String feature) {
		return message.equals(feature);
	}
}
