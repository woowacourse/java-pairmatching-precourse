package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairKey;
import pairmatching.repository.CrewMembers;
import pairmatching.repository.PairMap;
import pairmatching.view.ErrorMessage;

public class PairMatchingService {
	private static final int MAX_TRIAL = 3;

	public static void match(List<String> input) {
		Course course = Course.find(input.get(0));
		Level level = Level.find(input.get(1));
		Mission mission = Mission.find(input.get(2));

		List<Crew> crews = CrewMembers.getCrewsByCourse(course);
		try {
			Validator.checkCrewsSize(crews);
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return;
		}
		PairKey key = new PairKey(course, level, mission);
		matchCrews(key, crews);
	}

	private static void matchCrews(PairKey key, List<Crew> crews) {
		int trial = 0;
		while (trial < MAX_TRIAL) {
			crews = Randoms.shuffle(crews);
			if (isValidPair(crews)) {
				PairMap.add(key, crews);
				return;
			}
			trial++;
		}

		throw new IllegalArgumentException("매칭하는 데 실패했습니다. 잠시 후 다시 시도 해주세요.");
	}

	private static boolean isValidPair(List<Crew> crews) {
		// 이전에 매칭한 적이 있는지 확인

		return true;
	}

}
