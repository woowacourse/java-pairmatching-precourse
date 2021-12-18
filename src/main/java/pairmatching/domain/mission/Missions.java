package pairmatching.domain.mission;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Missions {
	private final List<String> missions;

	private Missions(List<String> missions) {
		this.missions = missions;
	}

	public static Missions of(String... missions) {
		return new Missions(Arrays.asList(missions));
	}

	public List<String> getMissions() {
		return Collections.unmodifiableList(missions);
	}

	@Override
	public String toString() {
		return missions.toString();
	}
}
