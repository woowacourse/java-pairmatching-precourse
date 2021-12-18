package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Mission {
	private String name;
	private List<CrewPair> crewPairs = new ArrayList<>();

	public Mission(String name) {
		this.name = name;
	}

	public void setCrewPairs(List<CrewPair> crewPairs) {
		this.crewPairs = crewPairs;
	}

	public List<String> getCrewPairNameList() {
		return crewPairs.stream()
			.map(crewPair -> crewPair.toString())
			.collect(Collectors.toList());
	}
	public static Mission from(String name) {
		return new Mission(name);
	}

	public boolean isExistPairMatching() {
		return !crewPairs.isEmpty();
	}

	public boolean hasSameCrewPair(List<Crew> crews) {
		for (CrewPair crewPair : crewPairs) {
			if(crewPair.isSame(crews)) {
				return false;
			}
		}
		return true;
	}

	public void resetCrewPairs() {
		crewPairs.clear();
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Mission mission = (Mission)o;
		return Objects.equals(name, mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
