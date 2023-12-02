package pairmatching.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.constants.Mission;
import pairmatching.global.exception.CustomException;
import pairmatching.global.exception.ErrorMessage;

public class Matching {
	private Map<Mission, Pairs> matching;

	public Matching() {
		matching = new EnumMap<>(Mission.class);
	}

	/**
	 * 페어 생성
	 */
	public void save(Mission mission, Pairs pairs) {
		matching.put(mission, pairs);
	}

	/**
	 * 페어 조회
	 */
	public Pairs getPairs(Mission mission) {
		if (matching.containsKey(mission)) {
			return matching.get(mission);
		}
		throw CustomException.from(ErrorMessage.NO_MATCHING_HISTORY);
	}

	/**
	 * 페어 초기화
	 */
	public void clear() {
		matching.clear();
	}

	/**
	 * 매칭 정보가 있음을 확인하는 메서드
	 */
	public boolean isEmpty(Mission enteredMission) {
		return !matching.containsKey(enteredMission);
	}

	public List<Pairs> getSameLevelPairs(Mission mission) {
		List<Pairs> pairs = new ArrayList<>();
		for (Mission others : matching.keySet()) {
			if (others.equals(mission)) {
				continue;
			}

			if (others.getLevel() == mission.getLevel()) {
				pairs.add(matching.get(mission));
			}
		}
		return pairs;
	}
}
