package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
	private String mission;
	private List<Pair> pairs = new ArrayList<>();

	public Pairs(String mission) {
		this.mission = mission;
	}

	public void addPair(String name1, String name2) {
		Pair pair = new Pair(name1, name2);
		pairs.add(pair);
	}

	public void addPair(String name1, String name2, String name3) {
		Pair pair = new Pair(name1, name2, name3);
		pairs.add(pair);
	}
}
