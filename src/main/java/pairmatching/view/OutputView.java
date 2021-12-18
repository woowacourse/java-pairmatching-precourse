package pairmatching.view;

import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.dto.ResponsePairsDto;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class OutputView {
	private static final String HASH_SEPARATOR = "#############################################";
	private static final String COURSE_LIST_FORM = "과정: %s";
	private static final String LEVEL_LIST_MESSAGE = "미션:";
	private static final String LEVEL_LIST_FORM = "  - %s: %s";
	private static final String FAIR_RESULT_MESSAGE = "페어 매칭 결과입니다.";
	private static final String FAIR_RESULT_SEPARATOR = " : ";
	private static final String INIT_PAIR_MESSAGE = "초기화 되었습니다.";

	public static void outputCourseAndLevel() {
		System.out.println(HASH_SEPARATOR);
		System.out.println(String.format(COURSE_LIST_FORM, Course.getNamesJoinBar()));
		System.out.println(LEVEL_LIST_MESSAGE);
		for (Level level : Level.values()) {
			System.out.println(String.format(LEVEL_LIST_FORM, level.getName(), level.getMissionsJoinBar()));
		}
		System.out.println(HASH_SEPARATOR);
	}

	public static void outputPairsResult(ResponsePairsDto responsePairsDto) {
		Pairs pairs = responsePairsDto.getPairs();
		System.out.println(FAIR_RESULT_MESSAGE);
		for (Pair pair : pairs.getPairs()) {
			System.out.println(String.join(FAIR_RESULT_SEPARATOR, pair.getPair()));
		}
		System.out.println();
	}

	public static void outputInitPair() {
		System.out.println(INIT_PAIR_MESSAGE);
		System.out.println();
	}

	public static void outputExceptionMessage(Exception e) {
		System.out.println(e.getMessage());
	}
}
