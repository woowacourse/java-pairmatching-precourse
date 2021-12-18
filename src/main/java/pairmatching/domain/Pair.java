package pairmatching.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Pair {

	private Set<String> names;

	public Pair(String firstName, String secondName) {
		this.names = new LinkedHashSet<>();
		names.add(firstName);
		names.add(secondName);
	}

	public void addName(String name) {
		names.add(name);
	}

	@Override
	public String toString() {
		return String.join(" : ", names.toArray(new String[0]));
	}
}
