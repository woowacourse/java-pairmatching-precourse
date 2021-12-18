package pairmatching.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import pairmatching.domain.level.Level;
import pairmatching.domain.mission.Missions;

public class MissionRepository {
	private static final Map<Level, Missions> levels = new LinkedHashMap<>();

	static {
		levels.put(Level.LEVEL1, Missions.of("자동차경주", "로또", "숫자야구게임"));
		levels.put(Level.LEVEL2, Missions.of("장바구니", "결제", "지하철노선도"));
		levels.put(Level.LEVEL4, Missions.of("성능개선", "배포"));
		// TODO: 가능하면 상수로 개선
	}

	public static Missions findMissions(Level level) {
		// 존재안할 시 빈 Missions 객체 반환
		return levels.getOrDefault(level, Missions.of());
	}
}
