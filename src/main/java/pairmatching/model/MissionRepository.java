package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MissionRepository {
	public static final List<Mission> missions = new ArrayList<>();

	public static final List<Mission> missions() {
		return Collections.unmodifiableList(missions);
	}

	public static void addMission(Mission mission) {
		missions.add(mission);
	}
}
