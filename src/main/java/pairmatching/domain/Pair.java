package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.util.Constants;

public class Pair {
	private final List<Crew> crews = new ArrayList<>();

	public void addCrew(Crew crew) {
		crews.add(crew);
	}

	@Override
	public String toString() {
		List<String> crewName = new ArrayList<>();
		crews.forEach(crew -> crewName.add(crew.toString()));
		return String.join(Constants.PAIR_MATCHING_SEPARATOR, crewName);
	}
}
