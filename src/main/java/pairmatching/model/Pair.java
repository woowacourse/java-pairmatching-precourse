package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	public static final String DELIMITER = " : ";

	private final List<Crew> crews = new ArrayList<>();

	public Pair(Crew... crews) {
		Collections.addAll(this.crews, crews);
	}

	public List<Crew> get() {
		return crews;
	}

	public static Pair create(Crew... crews) {
		return new Pair(crews);
	}

	public boolean is(Pair pair) {
		return pair.get().containsAll(crews);
	}

	@Override
	public String toString() {
		return crews.stream()
			.map(Crew::getName)
			.collect(Collectors.joining(DELIMITER));
	}
}
