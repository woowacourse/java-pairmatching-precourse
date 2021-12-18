package pairmatching.model;

import java.util.List;
import java.util.Set;

import pairmatching.model.enums.Assignment;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Mission;
import pairmatching.model.enums.Process;

public class Matching {
	private Process process;
	private Level level;
	private Assignment assignment;
	private List<Set<String>> combination;

	public Matching(Process process, Level level, Assignment assignment) {
		validateMatching(level, assignment);
		this.process = process;
		this.level = level;
		this.assignment = assignment;
	}

	private void validateMatching(Level level, Assignment assignment) {
		if (!Mission.hasLevelAndAssignment(level, assignment)) {
			throw new IllegalArgumentException("[ERROR] 선택한 레벨과 미션이 맞지 않습니다.");
		}
	}

	public boolean equals(Matching newMatching) {
		return process == newMatching.process
			&& level == newMatching.level
			&& assignment == newMatching.assignment;
	}

	// public List<Set<String>> getCombination() {
	// 	ProcessCrew ProcessCrew = getProcessCrew();
	//
	// }

	// private ProcessCrew getProcessCrew() {
	// 	if (process == Process.BACK_END) {
	// 		return new BackEnd();
	// 	}
	// 	return new FrontEnd();
	// }
}
