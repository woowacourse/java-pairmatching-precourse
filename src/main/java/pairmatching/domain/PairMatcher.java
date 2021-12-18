package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatcher {
	private final List<Matching> matchings = new ArrayList<>();

	public boolean haveDupPairs(List<Pair> pairs, MatchingOption matchingOption) {
		if (matchings.isEmpty()) {
			return false;
		}
		//matching에서 중복된 pair 찾기
		List<Matching> courseMatchings = matchings.stream()
			.filter(matching -> matching.isCourse(matchingOption.getCourse()))
			.collect(Collectors.toList());

		return true;
	}

	public boolean existMatching(MatchingOption matchingOption) {
		Matching existMatching = matchings.stream()
			.filter(matching -> matching.isMatched(matchingOption))
			.findAny()
			.orElse(null);
		return existMatching != null;
	}

	public void addMatching(Matching matching){
		this.matchings.add(matching);
	}
}
