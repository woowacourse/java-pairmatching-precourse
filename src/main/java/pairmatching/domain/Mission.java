package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mission {
	private String name;
	private List<Crew> crewPairs = new ArrayList<>();

	public Mission(String name) {
		this.name = name;
	}

	public static Mission from(String name) {
		return new Mission(name);
	}

	public boolean isExistPairMatching() {
		return !crewPairs.isEmpty();
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
