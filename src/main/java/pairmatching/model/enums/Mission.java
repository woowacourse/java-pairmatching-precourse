package pairmatching.model.enums;

import static pairmatching.model.enums.Assignment.*;
import static pairmatching.model.enums.Level.*;

import java.util.Arrays;

public enum Mission {
	MISSION_1(LEVEL_1, ASSIGNMENT_1),
	MISSION_2(LEVEL_2, ASSIGNMENT_2),
	MISSION_3(LEVEL_3, ASSIGNMENT_3),
	MISSION_4(LEVEL_4, ASSIGNMENT_4),
	MISSION_5(LEVEL_5, ASSIGNMENT_5);

	private Level level;
	private Assignment assignment;

	Mission(Level level, Assignment assignment) {
		this.level = level;
		this.assignment = assignment;
	}

	public static String getMissionMessage() {
		StringBuilder result = new StringBuilder();
		Arrays.stream(Mission.values())
			.forEach(mission -> result.append("\n" + mission.level + mission.assignment));
		return result.toString();
	}

	public static boolean hasLevelAndAssignment(Level level, Assignment assignment) {
		return Arrays.stream(Mission.values())
			.anyMatch(mission -> mission.level == level && mission.assignment == assignment);
	}
}
