package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private List<String> pair;

	private Pair() {
		this.pair = new ArrayList<>();
	}

	public static Pair newInstance() {
		return new Pair();
	}

	public void add(String name) {
		pair.add(name);
	}
}
