package pairmatching.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.MatchObjective;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.exception.MatchFailException;

public class MatcherService {
	private CrewService crewService;

	public MatcherService() {
		this.crewService = new CrewService();
	}

	public Mission match(MatchObjective matchObjective, int trialNumber) {
		try {
			Mission mission = matchOnce(matchObjective);
			crewService.addToHistory(mission.getCourse(), mission.getLevel(),mission.getPairList());
			return mission;
		} catch (MatchFailException e) {
			if(trialNumber == 3)
				throw new MatchFailException("매칭에 실패했습니다");
			return match(matchObjective, trialNumber + 1);
		}
	}

	private Mission matchOnce(MatchObjective matchObjective) throws MatchFailException {
		List<String> crews = crewService.getCrewsShuffled(matchObjective.getCourse());

		List<Pair> result = new ArrayList<>();
		for (int i = 0; i < crews.size(); i += 2) {
			if (crews.size() - i - 2 == 3)
				break;
			result.add(new Pair(Arrays.asList(crews.get(i), crews.get(i + 1))));
		}
		if (crews.size() % 2 == 1) {
			result.get(result.size() - 1).addCrew(crews.get(crews.size() - 1));
		}
		validatePairs(matchObjective.getCourse(), matchObjective.getLevel(), result);

		return new Mission(matchObjective.getCourse(), matchObjective.getLevel(), matchObjective.getMission(), result);
	}

	private void validatePairs(Course course, Level level, List<Pair> pairs) {
		pairs.forEach(pair -> validatePair(course, level, pair));
	}

	private void validatePair(Course course, Level level, Pair pair) {
		pair.getCrews().forEach(name -> validatePairEach(course, level, pair, name));
	}

	private void validatePairEach(Course course, Level level, Pair pair, String name) {
		for (String crew : pair.getCrewsExcept(name)) {
			if (crewService.didMeet(course, level, name, crew))
				throw new MatchFailException("매칭 실패");
		}
	}

}
