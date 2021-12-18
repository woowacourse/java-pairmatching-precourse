package pairmatching.domain;

import static pairmatching.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pair {
	private List<Crew> crewList = new ArrayList<>();

	public Pair(Crew... crews) {
		for (Crew crew : crews) {
			crewList.add(crew);
		}
	}

	@Override
	public String toString() {
		return String.join(COLON, getCrewNameList());
	}

	private List<String> getCrewNameList() {
		return crewList.stream().map(crew -> crew.toString()).collect(Collectors.toList());
	}

	public static boolean duplicatedPairs(Pair one, Pair other) {
		return one.crewList.stream().filter(crew -> other.crewList.contains(crew)).count() >= 2;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || getClass() != other.getClass())
			return false;
		Pair pair = (Pair)other;
		return duplicate(this, pair);
	}

	private boolean duplicate(Pair pair, Pair other) {
		return pair.crewList.stream().allMatch(crew -> other.crewList.contains(crew));
	}

	@Override
	public int hashCode() {
		return Objects.hash(crewList);
	}
}
