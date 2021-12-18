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

}
