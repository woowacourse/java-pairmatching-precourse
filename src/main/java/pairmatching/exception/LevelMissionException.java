package pairmatching.exception;

public class LevelMissionException {

	static final String INCORRECT_LEVEL_AND_MISSION = "레벨과 미션이 맞지 않습니다.";

	public static void checkMatchLevelAndMission(String level, String mission) {
		if (!(checkLevelOne(level, mission)||checkLevelTwo(level, mission)||checkLevelFour(level, mission))) {
			throw new IllegalArgumentException(INCORRECT_LEVEL_AND_MISSION);
		}
	}

	private static boolean checkLevelOne(String level, String mission) {
		return level.equals("레벨1") && (mission.equals("자동차경주") || mission.equals("로또") || mission.equals("숫자야구게임"));
	}

	private static boolean checkLevelTwo(String level, String mission) {
		return level.equals("레벨2")&&(mission.equals("장바구니")||mission.equals("결제")||mission.equals("지하철노선도"));
	}

	private static boolean checkLevelFour(String level, String mission) {
		return level.equals("레벨4")&&(mission.equals("성능개선")||mission.equals("배포"));
	}
}
