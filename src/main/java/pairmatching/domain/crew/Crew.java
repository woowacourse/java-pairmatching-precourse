package pairmatching.domain.crew;

import java.util.HashSet;
import java.util.Set;

public class Crew {
	private String name;
	private Set<String> history;

	public Crew(String name) {
		this.name = name;
		this.history = new HashSet<>();
	}

	public void addHistory(String name) {
		history.add(name);
	}

	public boolean isAlreadyMeet(String name) {
		return history.contains(name);
	}

}
