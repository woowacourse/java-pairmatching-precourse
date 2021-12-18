package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private List<Crew> crews;

	public Pair(List<Crew> crews) {
		this.crews = crews;
	}

	@Override
	public String toString() {
		return crews.stream().map(Crew::toString).collect(Collectors.joining(" : "));
	}
}
