package pairmatching.view;

import java.util.HashMap;

import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class OutputView {
	public static final String INPUT_FUNCTION_ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.";
	public static final String INPUT_COURSE_LEVEL_MISSION_ERROR_MESSAGE = "[ERROR] 잘못된 코스, 미션 입니다. 다시 입력해 주세요.";
	public static final String PAIR_RESULT_MESSAGE = "페어 매칭 결과입니다.";

	public static void printInputFunctionError() {
		System.out.println(INPUT_FUNCTION_ERROR_MESSAGE);
	}

	public static void printInputCourseLevelMissionError() {
		System.out.println(INPUT_COURSE_LEVEL_MISSION_ERROR_MESSAGE);
	}

	public static void printPairResult(Pairs pairList) {
		System.out.println(PAIR_RESULT_MESSAGE);
		for (Pair pair : pairList.pairList) {
			System.out.println(pair.getCrew1().getName() + " : " + pair.getCrew2().getName());
		}
	}
}
