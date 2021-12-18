package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.repository.LevelMissionMap;

public class MissionController {

	public static void initLevelToMission() {
		// 리팩토링 필요
		LevelMissionMap.add(Level.LEVEL1, "자동차경주");
		LevelMissionMap.add(Level.LEVEL1, "로또");
		LevelMissionMap.add(Level.LEVEL1, "숫자야구게임");

		LevelMissionMap.add(Level.LEVEL2, "장바구니");
		LevelMissionMap.add(Level.LEVEL2, "결제");
		LevelMissionMap.add(Level.LEVEL2, "지하철노선도");

		LevelMissionMap.add(Level.LEVEL4, "성능개선");
		LevelMissionMap.add(Level.LEVEL4, "배포");
	}

}
