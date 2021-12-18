package pairmatching.domain.level;

import java.util.Arrays;

public class Level {
	private final String[] missions;

	public Level(String[] missions) {
		this.missions = missions;
	}

	public boolean contains(String mission) {
		return missions.length == 0 || Arrays.asList(missions).contains(mission);
	}
}
