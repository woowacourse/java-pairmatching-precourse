package pairmatching.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.exception.DuplicatedMissionNameException;

public class MissionRepository {
	public static final String DELIMITER_FOR_MISSION_INFO = "-";
	public static final int LEVEL_INFO_INDEX = 0;
	public static final int MISSION_NAME_INDEX = 1;
	private final List<Mission> missions;

	public MissionRepository(List<String> missions) {
		validateMissionNames(missions);
		this.missions = createMissionList(missions);
	}

	public Mission getMissionByLevelAndName(Level level, String missionName) {
		return missions.stream()
			.filter(
				mission -> Objects.equals(mission.getName(), missionName)
					&& Objects.equals(level, mission.getLevel()))
			.findFirst()
			.get();
	}

	private List<Mission> createMissionList(List<String> missions) {
		return missions
			.stream()
			.map(e -> new Mission(
				Level.valueOf(e.split(DELIMITER_FOR_MISSION_INFO)[LEVEL_INFO_INDEX]),
				e.split(DELIMITER_FOR_MISSION_INFO)[MISSION_NAME_INDEX]))
			.collect(Collectors.toList());
	}

	private void validateMissionNames(List<String> missions) {
		Set<Mission> missionSet = new HashSet<>();
		missions.forEach(e -> {
			String[] split = e.split(DELIMITER_FOR_MISSION_INFO);
			missionSet.add(new Mission(Level.valueOf(split[0]), split[1]));
		});

		if (missionSet.size() != missions.size()) {
			throw new DuplicatedMissionNameException();
		}
	}

	public boolean isValidMission(String missionInput) {
		return missions.stream()
			.filter(mission -> Objects.equals(mission.getName(), missionInput))
			.collect(Collectors.toList())
			.size() > 0;
	}
}
