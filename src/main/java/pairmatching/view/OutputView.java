package pairmatching.view;

import pairmatching.domain.Matching;
import pairmatching.domain.Mission;
import pairmatching.validator.MatchingValidator;

public class OutputView {
	private static final String LINE = "#############################################";
	private static final String MISSION = "미션:";
	private static final String COURSE = "과정: 백엔드 | 프론트엔드";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";


	public static void printAdvanceInformation() {
		final Mission mission = new Mission();
		System.out.println(LINE);
		System.out.println(COURSE);
		System.out.println(MISSION);
		System.out.print(mission);
		System.out.println(LINE);
	}

	public static void printMatchingInfo(Matching matching) {
		String matchingInfoList = matching.toString();
		String matchingInfo = matchingInfoList.substring(1, matchingInfoList.length() - 1);
		String[] crewMatchingList = matchingInfo.split(",");
		for (String crewMatching : crewMatchingList) {
			System.out.println(crewMatching);
		}
	}

}
