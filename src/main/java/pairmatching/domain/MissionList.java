package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.enums.Level;

public class MissionList {
	private Map<Level, List<String>> missions = new HashMap<>();

	public MissionList() {
		setupLevel1();
		setupLevel2();
		setupLevel3();
		setupLevel4();
		setupLevel5();
	}

	public Map<Level, List<String>> getMission() {
		return Collections.unmodifiableMap(missions);
	}

	private void setupLevel1() {
		missions.put(Level.LEVEL1, new ArrayList<>());
		missions.get(Level.LEVEL1).add("자동차경주");
		missions.get(Level.LEVEL1).add("로또");
		missions.get(Level.LEVEL1).add("숫자야구게임");
	}

	private void setupLevel2() {
		missions.put(Level.LEVEL2, new ArrayList<>());
		missions.get(Level.LEVEL2).add("장바구니");
		missions.get(Level.LEVEL2).add("지하철노선도");
		missions.get(Level.LEVEL2).add("결제");
	}

	private void setupLevel3() {
		missions.put(Level.LEVEL3, new ArrayList<>());
	}

	private void setupLevel4() {
		missions.put(Level.LEVEL4, new ArrayList<>());
		missions.get(Level.LEVEL4).add("성능개선");
		missions.get(Level.LEVEL4).add("배포");
	}

	private void setupLevel5() {
		missions.put(Level.LEVEL5, new ArrayList<>());
	}
}
