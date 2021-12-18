package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
	private final List<Matching> matchings = new ArrayList<>();

	public boolean existMatching(MatchingOption matchingOption) {
		Matching existMatching = matchings.stream()
			.filter(matching -> matching.isMatched(matchingOption))
			.findAny()
			.orElse(null);
		return existMatching != null;
	}

	public void addMatching(Matching matching) {
		this.matchings.add(matching);
	}

	public List<Pair> getPairByMatchingOption(MatchingOption matchingOption) {
		Matching matchedPairs = matchings.stream()
			.filter(matching -> matching.isMatched(matchingOption))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다."));

		return matchedPairs.getPairs();
	}
}
