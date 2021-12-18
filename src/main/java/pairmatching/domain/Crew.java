package pairmatching.domain;

import java.util.Objects;

public class Crew implements Comparable<Crew> {
	private String name;

	public Crew(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Crew other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Crew crew = (Crew)other;
		return Objects.equals(name, crew.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
