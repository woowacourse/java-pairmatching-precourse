package pairmatching.domain;

import java.util.List;

public class Pairs {
	public List<Pair> pairs;

	public List<Pair> getPairList() {
		return pairs;
	}

	public Pairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

	public boolean contains(Pair pair) {
		return pairs.contains(pair);
	}
}
