package pairmatching.model;

import java.util.List;

public class Pairs {

	private final List<Pair> pairs;
	private final String mission;
	private final String course;

	public Pairs(List<Pair> pairs, String mission, String course) {
		this.pairs = pairs;
		this.mission = mission;
		this.course = course;
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public String getMission() {
		return mission;
	}
}
