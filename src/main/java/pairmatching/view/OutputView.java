package pairmatching.view;

import static constants.PairMatchingConstants.*;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}

	public static void printMenu() {
		System.out.println(MENU_LINE);
		System.out.println(COURSE_INFO + Course.BACKEND + SEPARATOR + Course.FRONTEND);
		System.out.println(MISSION_INFO);
		System.out.println(Level.LEVEL1);
		System.out.println(Level.LEVEL2);
		System.out.println(Level.LEVEL3);
		System.out.println(Level.LEVEL4);
		System.out.println(Level.LEVEL5);
		System.out.println(MENU_LINE);
	}

	public static void printPairResult(List<String> pair) {
		System.out.println(PAIR_MATCHING_RESULT);
		for (int idx = 0; idx < pair.size(); idx += 2) {
			System.out.println(pair.get(idx) + PAIR_COLON + pair.get(idx + 1));
		}
	}
}
