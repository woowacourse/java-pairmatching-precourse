package pairmatching.domain.pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pairmatching.domain.crew.Crew;

public class Pair {
	private Set<Crew> pair;

	private Pair(Set<Crew> pair) {
		this.pair = pair;
	}

	public static Pair from(List<Crew> crews) {
		Set<Crew> newCrews = new HashSet<>(crews);
		return new Pair(newCrews);
	}

	@Override
	public String toString() {
		return pair.toString();
	}
}
