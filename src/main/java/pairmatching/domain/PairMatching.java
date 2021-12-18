package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PairMatching {

	private List<Pair> pairs;

	public PairMatching(List<Pair> pairs) {
		this.pairs = pairs;
	}

	@Override
	public String toString() {
		return pairs.stream().map(Pair::toString).collect(Collectors.joining("\n"));
	}

	public boolean contains(Pair candidate) {
		for (Pair pair : pairs) {
			if (pair.isSame(candidate)) {
				return true;
			}
		}
		return false;
	}
}
