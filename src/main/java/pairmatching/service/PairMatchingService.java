package pairmatching.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.WoowaCourse;

public class PairMatchingService {
	public List<Pair> pairMatch(WoowaCourse woowaCourse) {
		List<Crew> load = woowaCourse.load();
		List<Crew> shuffle = Randoms.shuffle(load);
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < shuffle.size() - 2; i += 2) {
			Crew firstCrew = shuffle.get(i);
			Crew secondCrew = shuffle.get(i + 1);
			pairs.add(new Pair(Arrays.asList(firstCrew, secondCrew)));
		}
		return pairs;
	}
}
