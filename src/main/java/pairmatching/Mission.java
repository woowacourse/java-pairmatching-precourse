package pairmatching;

import java.util.ArrayList;
import java.util.List;

public enum Mission {
	RACING_CAR("자동차경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL("숫자야구게임", Level.LEVEL1),
	SHOPPING_CART("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY_MAP("지하철노선도", Level.LEVEL2),
	PERFORMANCE_DEVELOP("성능개선", Level.LEVEL4),
	DISTRIBUTION("배포", Level.LEVEL4);

	private String name;
	private Level level;

	Mission(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Level getLevel() {
		return this.level;
	}

	public static List<Mission> getMissionListByLevel(Level level) {
		List<Mission> missionList = new ArrayList<>();
		for (Mission mission : Mission.values()) {
			if (mission.getLevel().equals(level)) {
				missionList.add(mission);
			}
		}
		return missionList;
	}
}
