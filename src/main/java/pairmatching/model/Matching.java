package pairmatching.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import pairmatching.model.enums.Assignment;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Mission;
import pairmatching.model.enums.Process;
import pairmatching.model.process.BackEnd;
import pairmatching.model.process.FrontEnd;
import pairmatching.model.process.ProcessCrew;

public class Matching {
	private static final String NAME_DELIMITER = " : ";

	private Process process;
	private Level level;
	private Assignment assignment;
	private Set<Set<String>> combination = new HashSet<>();

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

	public void makeCombination() {
		ProcessCrew processCrew = getProcessCrew();
		List<String> crew = processCrew.getShuffledCrew();
		combination = getCombinationBy(crew);
	}

	private ProcessCrew getProcessCrew() {
		if (process == Process.BACK_END) {
			return new BackEnd();
		}
		return new FrontEnd();
	}

	private Set<Set<String>> getCombinationBy(List<String> crew) {
		if (crew.size() < 2) {
			combination.add(new LinkedHashSet<>(crew));
			return combination;
		}
		for (int index = 0; index < crew.size(); index += 2) {
			HashSet<String> pair = new LinkedHashSet<>();
			pair.add(crew.get(index));
			pair.add(crew.get(index + 1));
			combination.add(pair);
		}
		addLast(crew);
		return combination;
	}

	private void addLast(List<String> crew) {
		if (crew.size() % 2 == 1) {
			HashSet<String> last = new LinkedHashSet<>();
			last.add(crew.get(crew.size() - 1));
			combination.add(last);
		}
	}

	public Level getLevel() {
		return level;
	}

	public boolean hasSameCombination(Matching newMatching) {
		for (Set<String> set : combination) {
			if (newMatching.combination.containsAll(set)) {
				return true;
			}
		}
		return false;
	}

	public void deleteCombination() {
		combination = new HashSet<>();
	}

	public String getCombinationMessage() {
		if (combination.size() == 0) {
			throw new IllegalArgumentException("[ERROR] 매칭을 할 수 없습니다.");
		}
		StringBuilder result = new StringBuilder();
		combination.forEach(
			set -> result.append(String.join(NAME_DELIMITER, set) + "\n")
		);
		return result.toString();
	}
}
