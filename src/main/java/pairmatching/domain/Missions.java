package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Missions {
	private final List<Mission> missions = new ArrayList<>();

	public void add(Mission mission) {
		missions.add(mission);
	}
}
