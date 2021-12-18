package pairmatching;

import java.util.List;

public class Program {
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final String BACKEND_COURSE = "백엔드 과정";
	private static final String FRONTEND_COURSE = "프론트엔드 과정";

	private final CrewList frontEndCrews;
	private final CrewList backEndCrews;

	public Program() {
		frontEndCrews = Reader.getFrontEndCrewList();
		backEndCrews = Reader.getBackEndEndCrewList();
	}

	public void run() {
		Guide.PLEASE_SELECT_FUNCTION.print();
		ChoiceView.print();
		String choice = InputController.getFunctionChoice();
		runSelectedProcess(choice);
	}

	private void runSelectedProcess(String choice) {
		if (choice.equals("1")) {
			Guide.COURSE_INFO.print();
			PairList matchedPairs = runPairMatching();
			Guide.SHOW_PAIR_MATCHING_RESULT.print();
			Guide.printMatchingResult(matchedPairs);
		}
	}

	private PairList runPairMatching() {
		Guide.PLEASE_SELECT_COURSE_TUPLE.print();
		List<String> courseTuple = InputController.getCourseTupleChoice();
		return doPairMatching(courseTuple);
	}

	private PairList doPairMatching(List<String> courseTuple) {
		String course = courseTuple.get(COURSE_INDEX);
		int level = Utility.toIntFromLevelInString(courseTuple.get(LEVEL_INDEX));
		String mission = courseTuple.get(MISSION_INDEX);
		PairList matchedPairs = pairMatchingByCourse(course);
		PairList savedPairs = Level.getLevel(level).getRecord(course).get(mission);
		if (matchedPairs.hasDuplicate(savedPairs)) {
			return reRunPairMatching(courseTuple);
		}
		return matchedPairs;
	}

	private PairList pairMatchingByCourse(String course) {
		if (course.equals(FRONTEND_COURSE)) {
			return frontEndCrews.doPairMatching();
		}
		return backEndCrews.doPairMatching();
	}

	private PairList reRunPairMatching(List<String> courseTuple) {
		Guide.DUPLICATE_MATCHING_RESULT.print();
		boolean response = InputController.getReMatchResponse();
		if (response) {
			return doPairMatching(courseTuple);
		}
		return doPairMatching(courseTuple);
	}

}
