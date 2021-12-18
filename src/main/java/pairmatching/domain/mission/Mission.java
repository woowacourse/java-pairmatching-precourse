package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.pair.Pair;

public class Mission {
	private final String name;
	private List<Pair> pairs;

	public Mission(String name) {
		this.name = name;
		pairs = new ArrayList<>();
	}

	public boolean equals(String name) {
		return this.name.equals(name);
	}

	public boolean containsPair(Pair pair) {
		return pairs.stream().anyMatch(alreadyPair -> alreadyPair.alreadyPair(pair));
	}

	public void clear() {
		pairs.clear();
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public void addPairs(List<Pair> pairs) {
		this.pairs = pairs;
	}
}
