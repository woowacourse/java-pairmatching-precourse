package pairmatching.util;

import pairmatching.model.LevelMission;

public class MissionException {
	public LevelMission levelMission = new LevelMission();

	public MissionException() {
		levelMission = new LevelMission();
	}

	public String checkMissionNameIsInLevel(String level, String mission) {
		if (levelMission.mission.containsKey(mission)) {
			check(levelMission.mission.get(mission), level);
			return mission;
		}

		throw new IllegalArgumentException("[ERROR] 미션이 존재하지 않습니다.");
	}

	public void check(int idx, String level) {

		if (!levelMission.level[idx].equals(level)) {
			throw new IllegalArgumentException("[ERROR] 미션이 존재하지 않습니다.");
		}
	}
}
