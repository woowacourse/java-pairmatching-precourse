package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {

	private Set<List> pairCrews;

	public Matching(){
		this.pairCrews = new HashSet<>();
	}

	public Set<List> matching(List<String> crewNames) {
		Randoms.shuffle(crewNames);
		if (crewNames.size() % 2 == 0) {
			makeEvenNumberCrews(crewNames);
		}
		if (crewNames.size() % 2 != 0) {
			makeOddNumberCrews(crewNames);
		}
		return pairCrews;
	}

	private void makeEvenNumberCrews(List<String> crewNames) {
		for (int i = 0; i < crewNames.size() / 2; i += 2) {
			List<String> pair = new ArrayList<>();
			pair.add(crewNames.get(i));
			pair.add(crewNames.get(i + 1));
			pairCrews.add(pair);
		}
	}

	private void makeOddNumberCrews(List<String> crewNames) {
		for (int i = 0; i < (crewNames.size() / 2) - 1; i += 2) {
			List<String> pair = new ArrayList<>();
			pair.add(crewNames.get(i));
			pair.add(crewNames.get(i + 1));
			pairCrews.add(pair);
		}
		List<String> pair = new ArrayList<>();
		pair.add(crewNames.get(crewNames.size() - 1));
		pair.add(crewNames.get(crewNames.size() - 2));
		pair.add(crewNames.get(crewNames.size() - 3));
	}
}
