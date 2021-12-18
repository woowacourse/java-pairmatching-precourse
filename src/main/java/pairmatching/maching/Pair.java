package pairmatching.maching;

import java.util.List;

import pairmatching.crew.Crew;

public class Pair {
	private List<Crew> pairs;

	public Pair(List<Crew> pairs) {
		this.pairs = pairs;
	}

	public List<Crew> getCrews() {
		return pairs;
	}
}
