package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
	private final List<Pair> pairs = new ArrayList<>();

	public void init() {
		pairs.clear();
	}

	public boolean add(Pair pair) {
		if(isExists(pair)) {
			return false;
		}
		pairs.add(pair);
		return true;
	}

	public boolean isExists(Pair pair) {
		return pairs.stream()
			.anyMatch(p -> p.equals(pair));
	}
}
