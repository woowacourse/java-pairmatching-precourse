package pairmatching.domain.mission;

import java.util.Arrays;
import java.util.List;

public class Missions {
	private static final String TO_STRING_DELIMITER = " | ";

	private final List<String> missions;

	private Missions(List<String> missions) {
		this.missions = missions;
	}

	public static Missions of(String... missions) {
		return new Missions(Arrays.asList(missions));
	}

	public boolean contains(String mission) {
		return missions.contains(mission);
	}

	@Override
	public String toString() {
		if (missions != null) {
			return String.join(TO_STRING_DELIMITER, missions);
		}
		return "";
	}
}
