package pairmatching.service;

import pairmatching.model.Matching;
import pairmatching.model.enums.Assignment;
import pairmatching.model.enums.Level;
import pairmatching.model.enums.Process;

public class MatchingService {
	private static final String MATCHING_REGEX = "^.+,\\s.+,\\s.+$";
	private static final String MATCHING_DELIMITER = ", ";
	private static final int PROCESS = 0;
	private static final int LEVEL = 1;
	private static final int ASSIGNMENT = 2;

	public Matching validateMatching(String inputMatching) {
		validateMatchingRegex(inputMatching);
		String[] matching = inputMatching.split(MATCHING_DELIMITER);
		Process process = Process.getProcessByInput(matching[PROCESS]);
		Level level = Level.getLevelByInput(matching[LEVEL]);
		Assignment assignment = Assignment.getAssignmentByInput(matching[ASSIGNMENT]);
		return new Matching(process, level, assignment);
	}

	private void validateMatchingRegex(String inputMatching) {
		if (!inputMatching.matches(MATCHING_REGEX)) {
			throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션의 형식으로 입력하세요");
		}
	}
}
