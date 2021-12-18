package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;

public class PairMatcher {

	private List<List<Crew>> crewPairs;

	public List<List<Crew>> match(List<Crew> crews) {
		crewPairs = new ArrayList<>();
		List<Crew> shuffledCrews = Randoms.shuffle(crews);
		matchIfNotSizeOdd(shuffledCrews);
		matchIfSizeOdd(shuffledCrews);
		return crewPairs;
	}

	private void matchIfNotSizeOdd(List<Crew> crews) {
		if (isSizeOdd(crews)) {
			return;
		}
		for (int i = 0; i < crews.size() / 2; i++) {
			List<Crew> pair = new ArrayList<>();
			pair.add(crews.get(i * 2));
			pair.add(crews.get(i * 2 + 1));
			crewPairs.add(pair);
		}
	}

	private boolean isSizeOdd(List<Crew> crews) {
		return (crews.size() % 2 != 0);
	}

	private void matchIfSizeOdd(List<Crew> crews) {
		if (isNotSizeOdd(crews)) {
			return;
		}
		for (int i = 0; i < crews.size() / 2 - 1; i++) {
			List<Crew> pair = new ArrayList<>();
			pair.add(crews.get(i * 2));
			pair.add(crews.get(i * 2 + 1));
			crewPairs.add(pair);
		}
		List<Crew> pair = new ArrayList<>();
		pair.add(crews.get(crews.size() - 3));
		pair.add(crews.get(crews.size() - 2));
		pair.add(crews.get(crews.size() - 1));
		crewPairs.add(pair);
	}

	private boolean isNotSizeOdd(List<Crew> crews) {
		return !isSizeOdd(crews);
	}

}
