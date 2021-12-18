package pairmatching.view;

import java.util.List;

import pairmatching.domain.Crew;

public class OutputView {
	private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
	private static final String CREW_SPLIT_LINE = " : ";
	private static final String PAIR_INIT_MESSAGE = "초기화 되었습니다.";

	public static void alarmPairMatchingResult() {
		System.out.println();
		System.out.println(PAIR_MATCHING_RESULT);
	}

	public static void showPairMatchingResult(List<String> crewNames) {
		StringBuilder stringBuilder = new StringBuilder();
		for (String crewName : crewNames) {
			stringBuilder.append(crewName).append(CREW_SPLIT_LINE);
		}
		String substring = stringBuilder.substring(0, stringBuilder.length() - 2);
		System.out.println(substring.trim());
	}

	public static void initPair() {
		System.out.println();
		System.out.println(PAIR_INIT_MESSAGE);
	}
}
