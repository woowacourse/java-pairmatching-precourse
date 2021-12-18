package pairmatching.exception;

public class LevelMissionException {

	static final String INCORRECT_LEVEL_AND_MISSION = "레벨과 미션이 맞지 않습니다.";
	static final String LEVEL1 = "레벨1";
	static final String LEVEL2 = "레벨2";
	static final String LEVEL4 = "레벨5";
	static final String CAR = "자동차경주";
	static final String LOTTO = "로또";
	static final String BASEBALL = "숫자야구게임";
	static final String BASKET = "장바구니";
	static final String PAYMENT = "결제";
	static final String SUBWAY = "지하철노선도";
	static final String IMPROVE = "성능개선";
	static final String DISTRIBUTE = "배포";

	public static void checkMatchLevelAndMission(String level, String mission) {
		if (!(checkLevelOne(level, mission) || checkLevelTwo(level, mission) || checkLevelFour(level, mission))) {
			throw new IllegalArgumentException(INCORRECT_LEVEL_AND_MISSION);
		}
	}

	private static boolean checkLevelOne(String level, String mission) {
		return level.equals(LEVEL1) && (mission.equals(CAR) || mission.equals(LOTTO) || mission.equals(BASEBALL));
	}

	private static boolean checkLevelTwo(String level, String mission) {
		return level.equals(LEVEL2) && (mission.equals(BASKET) || mission.equals(PAYMENT) || mission.equals(SUBWAY));
	}

	private static boolean checkLevelFour(String level, String mission) {
		return level.equals(LEVEL4) && (mission.equals(IMPROVE) || mission.equals(DISTRIBUTE));
	}
}
