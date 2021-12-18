package pairmatching.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.domain.crew.BackendCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.FrontendCrewRepository;
import pairmatching.view.Output;

public class MatchingController {
	static final String ERROR_NOT_MATCHING_FOR_THREE_TIMES = "3회만에 매칭이 되지 않습니다.";
	static final int MAX_TRIAL = 3;
	static final int PAIR_UNIT = 2;
	static final int MAX_PAIR_UNIT = 3;

	public static void run(Mission targetMission) {
		for (int i = 0; i < MAX_TRIAL; i++) {
			List<List<Crew>> pairs = matchingPairs(targetMission);
			if(!validateSamePairs(targetMission, pairs)) {
				continue;
			}
			targetMission.setPairs(pairs);
			Output.pairs(pairs);
			return;
		}
		throw new IllegalArgumentException(ERROR_NOT_MATCHING_FOR_THREE_TIMES);
	}

	private static List<List<Crew>> matchingPairs(Mission mission) {
		List<Crew> randomOrderCrews = getRandomOrderCrews(mission);
		List<List<Crew>> pairs = new ArrayList<>();
		for(int i = 0; i < randomOrderCrews.size() - 1; i += PAIR_UNIT) {
			addPairs(randomOrderCrews, pairs, i);
			if ((i == randomOrderCrews.size() - MAX_PAIR_UNIT))
				break;
		}
		return pairs;
	}

	private static void addPairs(List<Crew> randomOrderCrews, List<List<Crew>> pairs, int i) {
		if ((randomOrderCrews.size() % PAIR_UNIT != 0) && (i == randomOrderCrews.size() - MAX_PAIR_UNIT)) {
			pairs.add(new ArrayList<>(randomOrderCrews.subList(i, i + MAX_PAIR_UNIT)));
			return;
		}
		pairs.add(new ArrayList<>(randomOrderCrews.subList(i, i + PAIR_UNIT)));
	}

	private static List<Crew> getRandomOrderCrews(Mission mission) {
		if (mission.getCourse() == Course.BACKEND) {
			return BackendCrewRepository.getRandomOrder();
		}
		if (mission.getCourse() == Course.FRONTEND) {
			return FrontendCrewRepository.getRandomOrder();
		}
		return new ArrayList<>();
	}

	private static boolean validateSamePairs(Mission targetMission, List<List<Crew>> pairs) {
		List<Mission> missionGroup
			= MissionRepository.getMissionsOfSameGroup(targetMission.getCourse(), targetMission.getLevel());
		for (Mission mission: missionGroup) {
			if (!targetMission.equals(mission) && mission.haveSamePair(pairs)) {
				return false;
			}
		}
		return true;
	}
}
