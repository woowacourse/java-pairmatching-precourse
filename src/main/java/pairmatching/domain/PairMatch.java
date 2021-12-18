package pairmatching.domain;

import java.util.List;

public class PairMatch {
	private Match match;
	private List<Pair> pairs;

	public PairMatch(Match match, List<Pair> pairs) {
		this.match = match;
		this.pairs = pairs;
	}

	public Match getMatch() {
		return match;
	}

	public List<Pair> getPairs() {
		return pairs;
	}
}
