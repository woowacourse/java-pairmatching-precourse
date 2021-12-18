package pairmatching.model;

import pairmatching.model.enums.Assignment;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Mission;
import pairmatching.model.enums.Process;

public class Matching {
	private Process process;
	private Level level;
	private Assignment assignment;

	public Matching(Process process, Level level, Assignment assignment) {
		validateMatching(level, assignment);
	}

	private void validateMatching(Level level, Assignment assignment) {
		if (!Mission.hasLevelAndAssignment(level, assignment)) {
			throw new IllegalArgumentException("[ERROR] 선택한 레벨과 미션이 맞지 않습니다.");
		}
	}
}
