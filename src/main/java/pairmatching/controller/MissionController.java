package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.repository.LevelToMission;

public class MissionController {

	public static void initLevelToMission() {
		// 리팩토링 필요
		LevelToMission.add(Level.LEVEL1, "자동차경주");
		LevelToMission.add(Level.LEVEL1, "로또");
		LevelToMission.add(Level.LEVEL1, "숫자야구게임");

		LevelToMission.add(Level.LEVEL2, "장바구니");
		LevelToMission.add(Level.LEVEL2, "결제");
		LevelToMission.add(Level.LEVEL2, "지하철노선도");

		LevelToMission.add(Level.LEVEL4, "성능개선");
		LevelToMission.add(Level.LEVEL4, "배포");
	}

}
