package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pair {
	private Mission mission;
	private List<Crew> crews;

	public Pair(Mission mission, List<Crew> crews) {
		this.mission = mission;
		this.crews = crews;
	}

	public List<Crew> getCrews() {
		return crews;
	}

	public Mission getMission() {
		return mission;
	}

	public boolean equals(Pair pair) {
		Set<Crew> crewSet = new HashSet<>();
		for (Crew crew : crews) {
			crewSet.add(crew);
		}
		for (Crew crew : pair.getCrews()) {
			crewSet.add(crew);
		}
		if (crewSet.size() == pair.getCrews().size()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crews);
	}
}
