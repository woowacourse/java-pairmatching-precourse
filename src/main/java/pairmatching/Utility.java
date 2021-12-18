package pairmatching;

public final class Utility {
	private static final String UNEXPECTED_ERROR = "[ERROR] 예상치 못한 에러입니다.";

	private Utility() {
	}

	public static int toIntFromLevelInString(String Level) throws IllegalArgumentException {
		if (Level.equals("레벨1")) {
			return 1;
		}
		if (Level.equals("레벨2")) {
			return 2;
		}
		if (Level.equals("레벨3")) {
			return 3;
		}
		if (Level.equals("레벨4")) {
			return 4;
		}
		if (Level.equals("레벨5")) {
			return 5;
		}
		throw new IllegalArgumentException(UNEXPECTED_ERROR);
	}
}
