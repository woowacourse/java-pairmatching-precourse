package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class MatchingPairs {
	private List<Pair> pairList = new ArrayList<>();

	//Pair 중에 3인짝이 하나 이하로 있는지 유효성 검사해야함

	public void add(Pair pair) {
		pairList.add(pair);
	}

	public MatchingPairs shuffle() {
		Optional<Pair> pair = pairList.stream().filter(p -> p.size() == 3).findFirst();

		if (pair.isPresent()) {
			pairList.remove(pair.get());
			this.pairList = Randoms.shuffle(pairList);
			pairList.add(pair.get());
			return this;
		}
		this.pairList = Randoms.shuffle(pairList);
		return this;
	}

	public String toString() {
		return pairList.stream()
			.map(Pair::toString)
			.collect(Collectors.joining("\n"));
	}
}
