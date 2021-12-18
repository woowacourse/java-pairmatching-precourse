package pairmatching.View;

import java.util.ArrayList;
import java.util.Map;

import pairmatching.domain.Crew;

public class OutputView {
	private static final String PAIR_MATHCING_RESULT_GUIDE_MESSEAGE = "페어 매칭 결과입니다.";
	private static final String NOT_MATHCING_HISTORY_ERROR_MESSEAGE = "[ERROR] 매칭 이력이 없습니다.";
	private static final String RESET_GUIDE_MESSEAGE = "초기화 되었습니다.";

	public static void printPairResult(Map<Crew, ArrayList<Crew>> pair) {
		System.out.println();
		System.out.println(PAIR_MATHCING_RESULT_GUIDE_MESSEAGE);
		for (Crew crew : pair.keySet()) {
			System.out.print(crew.getName());
			for (Crew crewName : pair.get(crew)) {
				System.out.print(" : " + crewName.getName());
			}
			System.out.println();
		}
	}

	public static void printErrorNotMathcingHistory() {
		System.out.println();
		System.out.println(NOT_MATHCING_HISTORY_ERROR_MESSEAGE);
	}

	public static void printPairResetMessage() {
		System.out.println();
		System.out.println(RESET_GUIDE_MESSEAGE);
	}
}