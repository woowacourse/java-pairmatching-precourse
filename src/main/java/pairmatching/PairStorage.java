package pairmatching;

import java.util.HashMap;
import java.util.HashSet;

public class PairStorage {
	private final HashMap<Crew, HashMap<Level, HashSet<Crew>>> pairMap = new HashMap<>();

	public PairStorage() {
		setPairMapLevel();
	}

	private void setPairMapLevel() {
		for (Crew crew : new Crews().getCrewList()) {
			HashMap<Level, HashSet<Crew>> levelMap = setLevelMapWithCrew(crew);
			pairMap.put(crew,levelMap);
		}
	}

	private HashMap<Level, HashSet<Crew>>  setLevelMapWithCrew(Crew crew) {
		HashMap<Level, HashSet<Crew>> individualLevelMap = new HashMap<>();
		for (Level level : Level.values()) {
			individualLevelMap.put(level, new HashSet<Crew>());
		}
		return individualLevelMap;
	}

	public HashMap<Crew, HashMap<Level, HashSet<Crew>>> getPairMap() {
		return pairMap;
	}
}
