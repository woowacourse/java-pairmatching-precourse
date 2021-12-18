package pairmatching.domain.level;

public enum LevelValues {
	LEVEL_1(0), LEVEL_2(1), LEVEL_3(2), LEVEL_4(3), LEVEL_5(4);

	private final int value;

	LevelValues(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
