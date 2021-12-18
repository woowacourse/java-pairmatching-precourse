package utils.validator;

public class MissionValidator {

	private MissionValidator() {
	}

	public static boolean isValidMission(String level, String mission) {
		if (level.equals("레벨1")) {
			checkMissionSuitableForLevelOne(mission);
			return true;
		}
		if (level.equals("레벨2")) {
			checkMissionSuitableForLevelTwo(mission);
			return true;
		}
		if (level.equals("레벨4")) {
			checkMissionSuitableForLevelFour(mission);
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨과 입력한 미션이 올바르지 않다.");
	}

	private static void checkMissionSuitableForLevelOne(String mission) {
		if (mission.equals("자동차경주") || mission.equals("로또") || mission.equals("숫자야구게임")) {
			return;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨에 입력한 미션이 없다.");
	}

	private static void checkMissionSuitableForLevelTwo(String mission) {
		if (mission.equals("장바구니") || mission.equals("결제") || mission.equals("지하철노선도")) {
			return;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨에 입력한 미션이 없다.");
	}

	private static void checkMissionSuitableForLevelFour(String mission) {
		if (mission.equals("성능개선") || mission.equals("배포")) {
			return;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨에 입력한 미션이 없다.");
	}
}
