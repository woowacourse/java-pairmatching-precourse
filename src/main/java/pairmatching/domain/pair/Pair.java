package pairmatching.domain.pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {
	private final Set<String> crews;

	public Pair(List<String> crewNames) {
		crews = new HashSet<>();
		crews.addAll(crewNames);
	}

	public boolean alreadyPair(Pair pair) {
		return crews.containsAll(pair.getCrews());
	}

	public Set<String> getCrews() {
		return crews;
	}

	@Override
	public String toString() {
		String[] crewNames = (String[])crews.toArray();
		StringBuilder result = new StringBuilder(crewNames[0]);
		for (int i = 1; i < crewNames.length; i++) {
			result.append(" : ").append(crewNames[i]);
		}
		return result.toString();
	}
}
