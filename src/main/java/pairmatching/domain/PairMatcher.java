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
}
