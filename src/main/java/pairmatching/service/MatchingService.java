package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Course;
import pairmatching.model.CourseLevelMission;
import pairmatching.model.Crew;
import pairmatching.model.Level;
import pairmatching.model.MatchingPairs;
import pairmatching.model.Mission;
import pairmatching.model.Pair;

public class MatchingService {
	public Mission match(CourseLevelMission courseLevelMission, List<Crew> backendCrews, List<Crew> frontEndCrews) {
		Course course = courseLevelMission.getCourse();
		Level level = courseLevelMission.getLevel();
		Mission mission = courseLevelMission.getMission();
		if (courseLevelMission.getCourse().equals(Course.BACKEND)) {
			return matching(level, mission, backendCrews);
		}
		return matching(level, mission, frontEndCrews);
	}

	public Mission matching(Level level, Mission mission, List<Crew> crews) {
		List<Crew> shuffledCrews = Randoms.shuffle(crews);

		if (shuffledCrews.size() % 2 == 0) {
			mission.setMatchingPairs(makeEvenPair(level, shuffledCrews, 1));
			return mission;
		}
		mission.setMatchingPairs(makeOddPair(level, shuffledCrews, 1));
		return mission;
	}

	private MatchingPairs makeEvenPair(Level level, List<Crew> crews, int count) {
		if (count >= 3) {
			throw new IllegalArgumentException("[ERROR] 매칭에 실패했습니다.");
		}

		MatchingPairs matchingPairs = new MatchingPairs();
		for (int i = 0; i < crews.size(); i += 2) {
			Pair pair = new Pair();
			pair.makePair(crews.get(i), crews.get(i + 1));
			try {
				crews.get(i).addMatchedCrew(level, crews.get(i + 1));
				crews.get(i + 1).addMatchedCrew(level, crews.get(i));
			} catch (IllegalArgumentException exception) {
				makeEvenPair(level, crews, count++);
			}
			matchingPairs.add(pair);
		}
		return matchingPairs;
	}

	private MatchingPairs makeOddPair(Level level, List<Crew> crews, int count) {
		if (count >= 3) {
			throw new IllegalArgumentException("[ERROR] 매칭에 실패했습니다.");
		}

		MatchingPairs matchingPairs = new MatchingPairs();
		for (int i = 0; i < crews.size() - 2; i += 2) {
			if (i == crews.size() - 3) {
				Pair pair = new Pair();
				pair.makePair(crews.get(i), crews.get(i + 1), crews.get(i + 2));
				try {
					crews.get(i).addMatchedCrew(level, crews.get(i + 1));
					crews.get(i + 1).addMatchedCrew(level, crews.get(i));
					crews.get(i).addMatchedCrew(level, crews.get(i + 2));
					crews.get(i + 2).addMatchedCrew(level, crews.get(i));
					crews.get(i + 1).addMatchedCrew(level, crews.get(i + 2));
					crews.get(i + 2).addMatchedCrew(level, crews.get(i + 1));
				} catch (IllegalArgumentException exception) {
					makeOddPair(level, crews, count++);
				}
				matchingPairs.add(pair);
				break;
			}
			Pair pair = new Pair();
			pair.makePair(crews.get(i), crews.get(i + 1));
			try {
				crews.get(i).addMatchedCrew(level, crews.get(i + 1));
				crews.get(i + 1).addMatchedCrew(level, crews.get(i));
			} catch (IllegalArgumentException exception) {
				makeOddPair(level, crews, count++);
			}
			matchingPairs.add(pair);
		}
		return matchingPairs;
	}
}
