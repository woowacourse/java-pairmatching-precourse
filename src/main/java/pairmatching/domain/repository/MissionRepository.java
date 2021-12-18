package pairmatching.domain.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionRepository {
	static List<Mission> missionList = new ArrayList<>();

	static {
		missionList.add(new Mission(Level.LEVEL1, "자동차 경주"));
		missionList.add(new Mission(Level.LEVEL1, "로또"));
		missionList.add(new Mission(Level.LEVEL1, "숫자야구게임"));
		missionList.add(new Mission(Level.LEVEL2, "장바구니"));
		missionList.add(new Mission(Level.LEVEL2, "결제"));
		missionList.add(new Mission(Level.LEVEL2, "지하철노선도"));
		missionList.add(new Mission(Level.LEVEL3, ""));
		missionList.add(new Mission(Level.LEVEL4, "자동차 경주"));
		missionList.add(new Mission(Level.LEVEL4, "자동차 경주"));
		missionList.add(new Mission(Level.LEVEL5, ""));
	}


	public Mission findMission(String level, String name) {
		return missionList.stream()
			.filter(mission -> mission.isSame(level, name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 미션 입력 값 입니다."));
	}
}
