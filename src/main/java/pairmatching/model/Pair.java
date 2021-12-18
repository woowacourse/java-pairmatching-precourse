package pairmatching.model;

import java.util.List;

public class Pair {
	private final List<String> pair;

	public Pair(List<String> pair) {
		this.pair = pair;
	}

	public List<String> getPair() {
		return pair;
	}
}
