package pairmatching.view;

import java.util.List;

import pairmatching.domain.Crew;

public class OutputView {
	private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
	private static final String CREW_SPLIT_LINE = " : ";

	public static void alarmPairMatchingResult() {
		System.out.println();
		System.out.println(PAIR_MATCHING_RESULT);
	}

	public static void showPairMatchingResult(List<Crew> crewList) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Crew crew : crewList) {
			stringBuilder.append(crew.getName()).append(CREW_SPLIT_LINE);
		}
		System.out.println(stringBuilder.toString());
	}
}
