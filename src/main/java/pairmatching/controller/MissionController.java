package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.repository.Missions;

public class MissionController {

	public static void initLevelToMission() {
		// 리팩토링 필요
		Missions.add(Level.LEVEL1, "자동차경주");
		Missions.add(Level.LEVEL1, "로또");
		Missions.add(Level.LEVEL1, "숫자야구게임");

		Missions.add(Level.LEVEL2, "장바구니");
		Missions.add(Level.LEVEL2, "결제");
		Missions.add(Level.LEVEL2, "지하철노선도");

		Missions.add(Level.LEVEL4, "성능개선");
		Missions.add(Level.LEVEL4, "배포");
	}

}
