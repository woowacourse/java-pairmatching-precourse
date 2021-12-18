package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private static final String CONNECTION = " : ";
	private List<Crew> crews;

	public Pair(List<String> crews) {
		this.crews = crews.stream().map(Crew::new).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return crews.stream().map(Crew::getName).collect(Collectors.joining(CONNECTION));
	}
}
