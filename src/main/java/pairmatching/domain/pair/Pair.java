package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private final List<String> crews;

	public Pair(List<String> crewNames) {
		crews = crewNames;
	}

	public boolean alreadyPair(Pair pair) {
		return crews.containsAll(pair.getCrews());
	}

	public List<String> getCrews() {
		return crews;
	}

	@Override
	public String toString() {
		List<String> crewNames = new ArrayList<>(crews);
		StringBuilder result = new StringBuilder(crewNames.get(0));
		for (int i = 1; i < crewNames.size(); i++) {
			result.append(" : ").append(crewNames.get(i));
		}
		return result.toString();
	}
}
