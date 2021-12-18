package pairmatching.domain;

import java.util.List;

public class Pair {
	private List<String> names;

	public Pair(List<String> names) {
		this.names = names;
	}

	public List<String> getNames() {
		return names;
	}
}
