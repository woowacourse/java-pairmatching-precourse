package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PairManager {
	private static final String ERROR_MISSION_NOT_IN_LEVEL = "해당 레벨의 미션이 아닙니다.";

	public MatchedPairs matchPair(Course course, Level level, Mission mission) {
		validateMission(level, mission);
		if (MatchedPairsRepository.isMatched(course, mission)) {
			// TODO: 재매치
		}
		List<String> names = CrewRepository.getNameList(course);
		List<String> shuffledNames = Randoms.shuffle(names);
		return new MatchedPairs(matchPair(course, shuffledNames), course, level, mission);
	}

	private void validateMission(Level level, Mission mission) {
		if (!mission.isLevel(level)) {
			throw new IllegalArgumentException(ERROR_MISSION_NOT_IN_LEVEL);
		}
	}

	private List<Pair> matchPair(Course course, List<String> names) {
		List<Pair> pairs = new ArrayList<>();
		int pairCount = names.size() / 2;
		for (int i = 0; i < pairCount; i++) {
			int startIndex = i * 2;
			List<Crew> crews = new ArrayList<>();
			crews.add(CrewRepository.findByName(names.get(startIndex), course));
			crews.add(CrewRepository.findByName(names.get(startIndex + 1), course));
			if (i == (pairCount - 1) && names.size() > (pairCount * 2)) {
				crews.add(CrewRepository.findByName(names.get(names.size() - 1), course));
			}
			Pair pair = new Pair(crews);
			pairs.add(pair);
		}
		return pairs;
	}
}
