package pairmatching.domain;

import java.util.List;

public class Pairs {
	private List<Pair> pairs;
	private List<String> condition;

	public Pairs(List<String> condition) {
		this.condition = condition;
	}
	public void add (Pair pair) {
		pairs.add(pair);
	}

	public List<String> getCondition () {
		return condition;
	}

	public List<Pair> getPairs() {
		return pairs;
	}
}
