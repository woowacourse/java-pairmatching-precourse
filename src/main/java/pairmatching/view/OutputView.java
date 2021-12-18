package pairmatching.view;

import pairmatching.domain.Matching;
import pairmatching.domain.Mission;

public class OutputView {
	private static final String LINE = "#############################################";
	private static final String MISSION = "미션:";
	private static final String COURSE = "과정: 백엔드 | 프론트엔드";
	private static final String PAIR_RESULT = "페어 매칭 결과입니다.";

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
		System.out.println(PAIR_RESULT);
		for (String crewMatching : crewMatchingList) {
			System.out.println(crewMatching);
		}
	}

}
