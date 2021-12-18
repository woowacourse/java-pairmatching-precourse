package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {
	private Set<String> crewSet;

	public Pair(List<String> crews) {
		this.crewSet = new HashSet<>();
		crewSet.addAll(crews);
	}
}
