package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Matching;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.constants.Course;
import pairmatching.domain.constants.Mission;
import pairmatching.global.exception.CustomException;
import pairmatching.global.exception.ErrorMessage;

public class MatchingService {
	private static final int MAX_MATCHING_COUNT = 3;
	private final CrewService crewService;
	private Matching matching;

	public MatchingService(CrewService crewService, Matching matching) {
		this.crewService = crewService;
		this.matching = matching;
	}

	public Pairs getPairs(Mission mission) {
		return matching.getPairs(mission);
	}

	/**
	 * 주어진 미션에 대한 매칭 정보가 없음을 검증하는 메서드
	 * @return 매칭 정보가 없는 상태인 미션이라면 true, 그렇지 않다면 false
	 */
	public boolean hasNoPairs(Mission enteredMission) {
		return matching.isEmpty(enteredMission);
	}

	/**
	 * 3회에 걸쳐 페어를 생성하고, 유효한 매칭 정보인 경우 매칭 정보를 저장하는 메서드
	 * @param mission 페어를 생성할 미션
	 * @return 새로 생성한 페어. 매칭에 실패하면 에러를 반환
	 */
	public Pairs generateMatching(Course course, Mission mission) {
		for (int i = 0; i < MAX_MATCHING_COUNT; i++) {
			Pairs generatedPairs = generatePairs(course);
			boolean canMatch = hasNotDuplicatedMatching(mission, generatedPairs);
			if (canMatch) {
				matching.save(mission, generatedPairs);
				return generatedPairs;
			}
		}
		throw CustomException.from(ErrorMessage.CANNOT_MATCHING_ERROR);
	}

	public Pairs generatePairs(Course course) {
		Pairs pairs = new Pairs();
		List<String> crews = Randoms.shuffle(crewService.getCrews(course));

		// 크루의 수가 홀수인 경우
		if (crews.size() % 2 == 1 && crews.size() >= 3) {
			pairs.add(generateTripleCrew(crews));
		}
		for (int i = 0; i < crews.size(); i += 2) {
			pairs.add(generateCoupleCrew(crews.get(i), crews.get(i + 1)));
		}

		return pairs;
	}

	private Pair generateCoupleCrew(String crew1, String crew2) {
		Pair pair = new Pair();
		pair.add(crew1);
		pair.add(crew2);
		return pair;
	}

	private Pair generateTripleCrew(List<String> crews) {
		Pair pair = new Pair();
		for (int i = 0; i < 3; i++) {
			int last = crews.size() - 1;
			pair.add(crews.get(last));
			crews.remove(last);
		}
		return pair;
	}

	/**
	 * 현재 미션의 레벨의 미션들과 중복되는 매칭 정보가 있는 지 확인하는 메서드
	 * @return 중복되는 매칭 정보가 없다면 true, 중복되는 매칭 정보가 있다면 false
	 */
	private boolean hasNotDuplicatedMatching(Mission mission, Pairs pairs) {
		List<Pairs> sameLevelPairs = matching.getSameLevelPairs(mission);
		for (Pairs others : sameLevelPairs) {
			if (pairs.duplicated(others)) {
				return false;
			}
		}
		return true;
	}

	public void clear() {
		matching.clear();
	}
}
