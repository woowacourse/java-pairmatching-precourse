package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pair {
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

}
