package utils.validator;

public class MissionValidator {

	private MissionValidator() {
	}

	public static boolean isValidMission(String level, String mission) {
		if (level.trim().equals("레벨1")) {
			checkMissionSuitableForLevelOne(mission);
		}
		if (level.trim().equals("레벨2")) {
			checkMissionSuitableForLevelTwo(mission);
		}
		if (level.trim().equals("레벨4")) {
			checkMissionSuitableForLevelFour(mission);
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨과 입력한 미션이 올바르지 않다.");
	}

	private static void checkMissionSuitableForLevelOne(String mission) {
		if (mission.trim().equals("자동차 경주") || mission.trim().equals("로또") || mission.trim().equals("숫자야구게임")) {
			return;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨에 입력한 미션이 없다.");
	}

	private static void checkMissionSuitableForLevelTwo(String mission) {
		if (mission.trim().equals("장바구니") || mission.trim().equals("결제") || mission.trim().equals("지하철노선도")) {
			return;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨에 입력한 미션이 없다.");
	}

	private static void checkMissionSuitableForLevelFour(String mission) {
		if (mission.trim().equals("성능개선") || mission.trim().equals("배포")) {
			return;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 레벨에 입력한 미션이 없다.");
	}
}
