package pairmatching.domain;

import java.util.List;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair = (Pair)o;
		return Objects.equals(mission, pair.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mission);
	}
}
