package pairmatching.domain.level;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.mission.Mission;
import pairmatching.domain.pair.Pair;

public class Level {
	private final List<Mission> missions;

	public Level(String[] missions) {
		this.missions = new ArrayList<>();

		for (String missionName : missions) {
			this.missions.add(new Mission(missionName));
		}
	}

	public boolean contains(String missionName) {
		return missions.size() == 0 || missions.stream().anyMatch(mission -> mission.equals(missionName));
	}

	public Mission getMission(String missionName) {
		return missions.stream().filter(mission -> mission.equals(missionName)).findFirst().orElse(null);
	}

	public boolean alreadyExistPair(Pair pair) {
		return missions.stream().anyMatch(mission -> mission.containsPair(pair));
	}
}
