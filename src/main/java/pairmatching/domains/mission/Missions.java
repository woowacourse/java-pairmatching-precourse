package pairmatching.domains.mission;

import java.util.ArrayList;
import java.util.List;

public class Missions {
	List<Mission> missions = new ArrayList<>();

	public void loadMission() {
		Mission[] missions = Mission.values();
		for (Mission mission : missions) {
			this.missions.add(mission);
		}
	}
}
