package pairmatching.service;

import pairmatching.controller.CrewController;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.level.Level;
import pairmatching.domain.level.LevelValues;
import pairmatching.domain.level.Levels;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.pair.Pair;
import pairmatching.exception.AlreadyExistPairException;

public class MatchingService {
	public void matchPair(String course, String levelValue, String missionName) {
		Levels levels = Levels.getInstance();
		Level level = levels.getLevel(LevelValues.valueOf(levelValue).getValue());
		Mission mission = level.getMission(missionName);
		mission.clear();
		Crews crews = CrewController.getRightCrews(course);

		while (!crews.done()) {
			Pair pair = crews.makePair();
			validateAlreadyExist(pair, mission);
			mission.addPair(pair);
		}
	}

	private void validateAlreadyExist(Pair pair, Mission mission) {
		if (mission.containsPair(pair)) {
			throw new AlreadyExistPairException();
		}
	}
}
