package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private List<Crew> crewList = new ArrayList<>();

	public Pair(Crew ...crews) {
		for (Crew crew : crews) {
			crewList.add(crew);
		}
	}

	@Override
	public String toString() {
		return String.join(" : ", getCrewNameList());
	}

	private List<String> getCrewNameList() {
		return crewList.stream().map(crew -> crew.toString()).collect(Collectors.toList());
	}
}
