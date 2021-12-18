package pairmatching.view;

import pairmatching.domain.Mission;

public class OutputView {
	private static final String LINE = "#############################################";
	private static final String MISSION = "미션:";
	private static final String COURSE = "과정: 백엔드 | 프론트엔드";
	private static final Mission mission = new Mission();

	public static void printAdvanceInformation() {
		System.out.println(LINE);
		System.out.println(COURSE);
		System.out.println(MISSION);
		System.out.print(mission);
		System.out.println(LINE);
	}
}
