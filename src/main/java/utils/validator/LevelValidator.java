package utils.validator;

public class LevelValidator {

	private LevelValidator() {
	}

	public static boolean isValidLevel(String level) {
		if (level.equals("레벨1") || level.equals("레벨2") || level.equals("레벨4")) {
			return true;
		}
		if (level.equals("레벨3") || level.equals("레벨5")) {
			throw new IllegalArgumentException("[ERROR] 입력한 레벨에는 진행 할수 있는 미션이 없다.");
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨이 올바른 래벨 입력이 아니다.");
	}
}
