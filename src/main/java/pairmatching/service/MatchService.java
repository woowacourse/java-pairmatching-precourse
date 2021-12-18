package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.CrewPair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatchService {

	public List<CrewPair> getRandomMatch(List<String> crewNames) {
		List<CrewPair> crewPairs = new ArrayList<>();
		List<String> shuffledNames = Randoms.shuffle(crewNames);
		for (int i = 0; i < shuffledNames.size() - 1; i += 2) {
			HashSet<String> pair = new HashSet<>();
			pair.add(shuffledNames.get(i));
			pair.add(shuffledNames.get(i+1));
			if (shuffledNames.size() % 2 == 1 && i == shuffledNames.size() - 3) {
				pair.add(shuffledNames.get(shuffledNames.size()-1));
			}
			crewPairs.add(new CrewPair(pair));
		}
		return crewPairs;
	}

	public List<String> randomMix(List<String> crewNames) {
		return Randoms.shuffle(crewNames);
	}
}
