package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private List<Crew> crews;

	public Pair(List<Crew> crews) {
		this.crews = new ArrayList<>(crews);
	}

	public void add(Crew crew) {
		this.crews.add(crew);
	}

	@Override
	public String toString() {
		return crews.stream().map(Crew::toString).collect(Collectors.joining(" : "));
	}

	public boolean isSame(Pair candidate) {
		Collections.sort(this.crews);
		Collections.sort(candidate.crews);
		return this.crews.equals(candidate.crews);
	}
}
