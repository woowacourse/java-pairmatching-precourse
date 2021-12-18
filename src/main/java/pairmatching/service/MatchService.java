package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchService {

	public List<String> getRandomMatch(List<String> crewNames) {
		List<String> crewPairs = new ArrayList<>();
		List<String> shuffledNames = Randoms.shuffle(crewNames);
		for (int i = 0; i < shuffledNames.size() - 1; i += 2) {
			List<String> pair = new ArrayList<>();
			pair.add(shuffledNames.get(i));
			pair.add(shuffledNames.get(i+1));
			if (shuffledNames.size() % 2 == 1 && i == shuffledNames.size() - 3) {
				pair.add(shuffledNames.get(shuffledNames.size()-1));
			}
			crewPairs.add(pair.stream().collect(Collectors.joining(" : ")));
		}
		return crewPairs;
	}

	public List<String> randomMix(List<String> crewNames) {
		return Randoms.shuffle(crewNames);
	}
}
