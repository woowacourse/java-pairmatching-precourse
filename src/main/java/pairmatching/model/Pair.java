package pairmatching.model;

import java.util.List;

public class Pair {

	private final List<String> crews;
	private final String mission;

	public Pair(List<String> crews, String mission) {
		this.crews = crews;
		this.mission = mission;
	}

	public List<String> getCrews() {
		return crews;
	}

	public int getCrewSize() {
		return crews.size();
	}
}
