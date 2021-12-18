package pairmatching.model;

import java.util.HashSet;
import java.util.stream.Collectors;

public class CrewPair {

	private HashSet<String> pair = new HashSet<>();

	public CrewPair(HashSet<String> pair) {
		this.pair = pair;
	}

	public boolean isAlreadyMatched(CrewPair crewPair) {
		return pair.contains(crewPair);
	}

	@Override
	public String toString() {
		return pair.stream().collect(Collectors.joining(" : "));
	}
}
