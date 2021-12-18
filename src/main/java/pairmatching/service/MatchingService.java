package pairmatching.service;

import java.util.List;

import pairmatching.domain.crew.Crews;
import pairmatching.domain.level.Level;
import pairmatching.domain.level.Levels;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.pair.Pair;
import pairmatching.exception.AlreadyExistPairException;
import pairmatching.view.OutputView;

public class MatchingService {
	public void matchPair(Crews crews, String levelValue, String missionName) {
		Levels levels = Levels.getInstance();
		Level level = levels.getLevel(levelValue);
		Mission mission = level.getMission(missionName);
		mission.clear();

		List<Pair> pairs = crews.makePairs();
		validateAlreadyExist(pairs, mission);
		mission.addPairs(pairs);

		OutputView.printPairs(mission.getPairs());
	}

	private void validateAlreadyExist(List<Pair> pairs, Mission mission) {
		pairs.forEach(pair -> {
			if (mission.containsPair(pair)) {
				throw new AlreadyExistPairException();
			}
		});
	}
}