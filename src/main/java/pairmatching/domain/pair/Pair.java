package pairmatching.domain.pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.domain.crew.Crew;

public class Pair {
	private Set<Crew> pair;

	private Pair(Set<Crew> pair) {
		this.pair = pair;
	}

	public static Pair from(List<Crew> crews) {
		Set<Crew> newCrews = new LinkedHashSet<>(crews);
		return new Pair(newCrews);
	}

	@Override
	public String toString() {
		List<String> stringList = new ArrayList<>();
		Iterator iterator = pair.iterator();
		while (iterator.hasNext()) {
			stringList.add(iterator.next().toString());
		}
		return String.join(" : ", stringList);
	}

}
