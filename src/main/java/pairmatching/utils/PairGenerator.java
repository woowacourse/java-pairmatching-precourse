package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.Pair;

public class PairGenerator {
	public static final int PAIR_SIZE = 2;

	public static List<Pair> generatePairs(Mission mission) {
		List<Pair> pairs = new ArrayList<>();
		List<Crew> shuffledCrews = Randoms.shuffle(CrewsGenerator.generateCrews(mission));

		int trial = 0;
		while (trial < 3) {
			pairs = getPairs(mission, shuffledCrews);
			if (validatePairs(mission, pairs)) {
				return pairs;
			}
			trial++;
		}
		throw new IllegalArgumentException("짝을 지을 수 없습니다.");
	}

	private static boolean validatePairs(Mission mission, List<Pair> pairs) {
		for (Pair pair : pairs) {
			if (isContainingSamePairInAnotherMission(mission, pair)) {
				return false;
			}
		}
		return true;
	}

	public static List<Pair> getPairs(Mission mission, List<Crew> shuffledCrews) {
		List<Pair> pairs = new ArrayList<>();

		int index = 0;
		for (index = 0; index < shuffledCrews.size() - PAIR_SIZE - 1; index += PAIR_SIZE) {
			List<Crew> pairing = new ArrayList<>();
			pairing.add(shuffledCrews.get(index));
			pairing.add(shuffledCrews.get(index+1));
			pairs.add(new Pair(pairing));
		}
		List<Crew> pairing = new ArrayList<>();
		for (;index < shuffledCrews.size(); index++) {
			pairing.add(shuffledCrews.get(index));
		}
		pairs.add(new Pair(pairing));
		return pairs;
	}

	public static boolean isContainingSamePairInAnotherMission(Mission mission, Pair pair) {
		return MissionRepository.missions().stream()
			.filter(otherMission -> otherMission.isSameCourse(mission.getCourse()))
			.filter(otherMission -> otherMission.isSameLevel(mission.getLevel()))
			.filter(otherMission -> !otherMission.isSameName(mission.getName()))
			.filter(otherMission -> !otherMission.isNotMatching())
			.map(otherMission -> otherMission.getPairs())
			.filter(pairs -> pairs.contains(pair))
			.count() > 0;
	}
}
