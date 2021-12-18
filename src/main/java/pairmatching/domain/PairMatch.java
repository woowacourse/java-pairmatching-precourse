package pairmatching.domain;

import java.util.List;

public class PairMatch {
	private Match match;
	private List<Pair> pair;

	public PairMatch(Match match, List<Pair> pair) {
		this.match = match;
		this.pair = pair;
	}
}
