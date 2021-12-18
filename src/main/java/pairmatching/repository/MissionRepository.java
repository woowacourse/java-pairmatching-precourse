package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.level.Level;
import pairmatching.domain.mission.Missions;

public class MissionRepository {
	private static final Map<Level, Missions> levels = new HashMap<>();

	static {
		levels.put(Level.LEVEL1, Missions.of("자동차경주", "로또", "숫자야구게임"));
		levels.put(Level.LEVEL2, Missions.of("장바구니", "결제", "지하철노선도"));
		levels.put(Level.LEVEL4, Missions.of("성능개선", "배포"));
		// TODO: 가능하면 상수로 개선
	}
}
