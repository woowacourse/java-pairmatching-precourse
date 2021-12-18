package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pair {
	private Set<String> crewSet;

	public Pair(List<String> crews) {
		this.crewSet = new HashSet<>();
		crewSet.addAll(crews);
	}

	public void addCrew(String name) {
		crewSet.add(name);
	}

	public List<String> getCrews() {
		return new ArrayList<>(crewSet);
	}

	public List<String> getCrewsExcept(String name) {
		return crewSet.stream().filter(s -> !s.equals(name)).collect(Collectors.toList());
	}

	public int size() {
		return crewSet.size();
	}

	@Override
	public String toString() {
		return String.join(" : ", crewSet);
	}
}
