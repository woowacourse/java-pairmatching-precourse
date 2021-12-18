package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import pairmatching.domain.crew.Crew;

public class Pair {
	private static final String TO_STRING_DELIMITER = " : ";

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
		return String.join(TO_STRING_DELIMITER, stringList);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair1 = (Pair)o;
		return pair.equals(pair1.pair);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pair);
	}
}
