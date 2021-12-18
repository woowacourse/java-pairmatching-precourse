package pairmatching.model;

import java.util.HashSet;

public class CrewPair {
	private HashSet<String> crews;

	public CrewPair(String joinedName) {
		this.crews = new HashSet<>();
		crews.add(joinedName);
	}

	public String toString() {
		return String.join("", this.crews);
	}
}
