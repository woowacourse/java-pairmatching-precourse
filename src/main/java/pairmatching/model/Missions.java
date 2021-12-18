package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Missions {
	private List<Mission> missionList;

	public static Missions init(String missionNames) {
		Missions missions = new Missions();
		missions.missionList = Arrays.stream(missionNames.split(","))
			.map(Mission::new)
			.collect(Collectors.toList());

		return missions;
	}

	public String toString() {
		return missionList
			.stream()
			.map(Mission::getName)
			.collect(Collectors.joining(" | "));
	}
}
